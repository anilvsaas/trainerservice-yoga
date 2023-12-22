package com.yoga.trainerserviceyoga.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AsyncImpl {
	@Autowired
	private MongoTemplate mongoTemplate;
}
