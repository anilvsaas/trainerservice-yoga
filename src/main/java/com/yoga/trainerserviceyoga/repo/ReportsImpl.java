package com.yoga.trainerserviceyoga.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.yoga.trainerserviceyoga.childmodel.TrainerSlot;
import com.yoga.trainerserviceyoga.model.MealplanModel;
import com.yoga.trainerserviceyoga.model.ProgramModel;
import com.yoga.trainerserviceyoga.model.SubscriptionModel;

@Repository
public class ReportsImpl implements Reports {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<SubscriptionModel>  getSubscriptions(String programId,String selection) {
		Query query = new Query();
		query.addCriteria(Criteria.where("program_id").is(programId));
		if(selection.equals("Active"))
            query.addCriteria(Criteria.where("isProgramActive").is(true));
		else if(selection.equals("Inactive"))
		    query.addCriteria(Criteria.where("isProgramActive").is(false));
		else if(selection.equals("Dollars")){
		    query.addCriteria(Criteria.where("isProgramActive").is(true));
		    query.addCriteria(Criteria.where("currencyPaidIn").is("USD"));
		}else if(selection.equals("RefundDollars")){
		    query.addCriteria(Criteria.where("subscriptionStatus").is("pg_1o1_refund_processed"));
		    query.addCriteria(Criteria.where("currencyPaidIn").is("USD"));
		}else if(selection.equals("RefundRupees")){
		    query.addCriteria(Criteria.where("subscriptionStatus").is("pg_1o1_refund_processed"));
		    query.addCriteria(Criteria.where("currencyPaidIn").is("INR"));
		}else if(selection.equals("published")){
		    query.addCriteria(Criteria.where("isProgramActive").is(true));
		    query.addCriteria(Criteria.where("isProgramPublished").is(true));
		}else{
			query.addCriteria(Criteria.where("isProgramActive").is(true));
			query.addCriteria(Criteria.where("currencyPaidIn").is("INR"));	
		}
		return this.mongoTemplate.find(query, SubscriptionModel.class, "yoga_subscriptions");
	}

	@Override
	public List<ProgramModel> getProgramstatus(String trainerId, String selection) {
		if(!selection.equals("Other")){
		    Query query = new Query();
		    query.addCriteria(Criteria.where("trainerId").is(trainerId));
            query.addCriteria(Criteria.where("status").is(selection));
        return this.mongoTemplate.find(query, ProgramModel.class);
		}else{
			Criteria criteria = new Criteria();
			criteria.orOperator(Criteria.where("status").is("Rejected"),Criteria.where("status").is("Under Review"),Criteria.where("status").is("Onhold"));
			Query query = new Query(criteria);
			query.addCriteria(Criteria.where("trainerId").is(trainerId));
			return this.mongoTemplate.find(query, ProgramModel.class);
		}
		
	}

	@Override
	public MealplanModel gettraineemealplan(String program_id, String trainee_id, String trainee_status) {
		    Query query = new Query();
		    query.addCriteria(Criteria.where("program_id").is(program_id));
            query.addCriteria(Criteria.where("trainee_id").is(trainee_id));
            query.addCriteria(Criteria.where("trainer_status").is(trainee_status));
		return this.mongoTemplate.findOne(query, MealplanModel.class);
	}

	@Override
	public List<TrainerSlot> getTrainerslots(String trainerId,String monthname,String calltype) {
		 Query query = new Query();
		 query.addCriteria(Criteria.where("trainerId").is(trainerId));
		 query.addCriteria(Criteria.where("month").is(monthname));
		 query.addCriteria(Criteria.where("callType").is(calltype));
		 query.addCriteria(Criteria.where("status").is("completed"));
		return this.mongoTemplate.find(query, TrainerSlot.class);
	}

}
