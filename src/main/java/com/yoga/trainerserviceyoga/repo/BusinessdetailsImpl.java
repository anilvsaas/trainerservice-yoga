package com.yoga.trainerserviceyoga.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.yoga.trainerserviceyoga.model.Bankaccountdetails;
import com.yoga.trainerserviceyoga.model.BusinessDetailsModel;
import com.yoga.trainerserviceyoga.model.BusinessDocuments;



@Repository
public class BusinessdetailsImpl implements Businessdetails {

	@Autowired
	private MongoTemplate mongoTemplate;

	//To update the mongoDB database with created by gangadhar and updated by gangadhar on 12-06-2020
	@Override
	public BusinessDetailsModel update(BusinessDetailsModel businessdetails) {
		BusinessDetailsModel result = null;
		try{
		Bankaccountdetails bankdetails = null;
		BusinessDocuments documents = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("trainerId").is(businessdetails.getTrainerId()));
		Update update = new Update();
		update.set("updatedOn", new Date());
		
		if (businessdetails.getBankAccountDetails()!= null)
			bankdetails = businessdetails.getBankAccountDetails();
			update.set("bankAccountDetails", bankdetails);
		if (businessdetails.getBusinessDocuments() != null)
			update.set("businessDocuments", businessdetails.getBusinessDocuments());
		
		//updating mongodb document with above record created by gangadhar and updated by gangadhar on 12-06-2020
		this.mongoTemplate.updateMulti(query, update, BusinessDetailsModel.class);
		result = mongoTemplate.findOne(query, BusinessDetailsModel.class);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return result;
	}

	@Override
	public List<BusinessDetailsModel> findBytrainerId(String trainerId) {
	    Query query = new Query();
		query.addCriteria(Criteria.where("trainerId").is(trainerId));
		return mongoTemplate.find(query, BusinessDetailsModel.class);
	}

	@Override
	public void saveBusinessDetails(BusinessDetailsModel inputbusinessdetails) {
		mongoTemplate.save(inputbusinessdetails);
	}

}
