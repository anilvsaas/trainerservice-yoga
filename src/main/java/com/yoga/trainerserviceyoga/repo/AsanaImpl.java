package com.yoga.trainerserviceyoga.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.yoga.trainerserviceyoga.model.AsanaModel;

@Repository
public class AsanaImpl implements AsanaInterface{
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void saveAsana(AsanaModel asanaModel) {
	this.mongoTemplate.save(asanaModel);
	}

	@Override
	public AsanaModel getAsana(String asanaId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("asanaId").is(asanaId));
		return this.mongoTemplate.findOne(query, AsanaModel.class);
	}

	@Override
	public void updateAsana(AsanaModel asanaModel) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("asanaId").is(asanaModel.getAsanaId()));
//		Update update = new Update();
//		if(asanaModel.getAdoptedName() != null)
//		update.set("", asanaModel.getAdoptedName());
//		if(asanaModel.getAsanaGoal() != null);
		this.mongoTemplate.save(asanaModel);
			
		
	}

	@Override
	public void deleteAsana(String asanaId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("asanaId").is(asanaId));
		this.mongoTemplate.remove(query, AsanaModel.class);
		
	}

	@Override
	public List<AsanaModel> getAllAsanas(String trainerId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("trainerId").is(trainerId));
		return this.mongoTemplate.find(query, AsanaModel.class);
	}

}
