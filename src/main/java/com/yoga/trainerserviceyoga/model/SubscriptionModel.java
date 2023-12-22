package com.yoga.trainerserviceyoga.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "yoga_subscriptions")
public class SubscriptionModel {
	@Id
	private String subscription_id;
	private Date subscription_date;
	private String program_id;
	private String trainee_id;
	private Date program_start_date;
	private Date program_end_date;
	private long order_id;
	private long invoice_id;
    private double priceWithTax;
    private boolean isProgramActive;
    private boolean isProgramPublished;
    private String subscriptionStatus;
    private String currencyPaidIn;
    private boolean isSlaCrossed;

	public boolean getIsSlaCrossed() {
		return isSlaCrossed;
	}

	public void setIsSlaCrossed(boolean isSlaCrossed) {
		this.isSlaCrossed = isSlaCrossed;
	}
   
    
	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	public String getCurrencyPaidIn() {
		return currencyPaidIn;
	}

	public void setCurrencyPaidIn(String currencyPaidIn) {
		this.currencyPaidIn = currencyPaidIn;
	}

	public Date getProgram_end_date() {
		return program_end_date;
	}

	public void setProgram_end_date(Date program_end_date) {
		this.program_end_date = program_end_date;
	}

	
    
    public boolean getIsProgramPublished() {
		return isProgramPublished;
	}

	public void setIsProgramPublished(boolean isProgramPublished) {
		this.isProgramPublished = isProgramPublished;
	}

	public boolean getIsProgramActive() {
		return isProgramActive;
	}

	public void setIsProgramActive(boolean isProgramActive) {
		this.isProgramActive = isProgramActive;
	}

	public double getPriceWithTax() {
		return priceWithTax;
	}

	public void setPriceWithTax(double priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getSubscription_id() {
		return subscription_id;
	}

	public void setSubscription_id(String subscription_id) {
		this.subscription_id = subscription_id;
	}

	public Date getSubscription_date() {
		return subscription_date;
	}

	public void setSubscription_date(Date subscription_date) {
		this.subscription_date = subscription_date;
	}

	public String getProgram_id() {
		return program_id;
	}

	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}

	public String getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(String trainee_id) {
		this.trainee_id = trainee_id;
	}

	public Date getProgram_start_date() {
		return program_start_date;
	}

	public void setProgram_start_date(Date program_start_date) {
		this.program_start_date = program_start_date;
	}

}
