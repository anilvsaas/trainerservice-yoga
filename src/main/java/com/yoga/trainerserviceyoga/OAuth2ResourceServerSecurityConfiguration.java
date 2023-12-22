package com.yoga.trainerserviceyoga;
import java.util.Collections;

import java.util.Map;
import java.util.logging.Filter;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

//import com.amazonaws.xray.entities.Subsegment;
//import com.amazonaws.xray.spring.aop.XRayEnabled;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@XRayEnabled

public class OAuth2ResourceServerSecurityConfiguration extends ResourceServerConfigurerAdapter {

  private final ResourceServerProperties resource;

  public OAuth2ResourceServerSecurityConfiguration(ResourceServerProperties resource) {
    this.resource = resource;
  }
 
  @Override
  public void configure(HttpSecurity http) throws Exception {

  	// Very important
    http.cors();

    http
       .csrf().disable()
	    // make sure we use stateless session; session won't be used to store user's state.
	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 	
	.and()
	    // handle an authorized attempts 
	    .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED));

    http.authorizeRequests()
        .antMatchers("/actuator/health").permitAll()
        .antMatchers("/actuator/**").permitAll()
        .antMatchers("/swagger-ui.html").permitAll()
//        .antMatchers("/api/trainer/yoga/**").hasAuthority("ADMIN_ROLE")
        .antMatchers("/api/trainer/yoga/**").permitAll()
        .anyRequest().authenticated();
  }

  @Value("${security.oauth2.resource.id:}")
  private String jwtAudResourceId;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.resourceId(jwtAudResourceId);
  }
  // Enabling Cognito Converter
  @Bean
  public TokenStore jwkTokenStore() {
	 // System.out.println("Check1");
    return new JwkTokenStore(
        Collections.singletonList(resource.getJwk().getKeySetUri()),
        new CognitoAccessTokenConverter(),
        null);
  }

}