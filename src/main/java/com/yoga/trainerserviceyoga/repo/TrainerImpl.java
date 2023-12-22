package com.yoga.trainerserviceyoga.repo;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.yoga.trainerserviceyoga.childmodel.profile.Category;
import com.yoga.trainerserviceyoga.model.Constants;
import com.yoga.trainerserviceyoga.model.TestDateModel;
import com.yoga.trainerserviceyoga.model.TraineeModel;
import com.yoga.trainerserviceyoga.model.TrainerModel;

@Repository
public class TrainerImpl implements Trainer {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public TrainerModel getTrainerById(String trainerId) {
		TrainerModel result = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("trainerId").is(trainerId));

		result = this.mongoTemplate.findOne(query, TrainerModel.class);

		return result;
	}

	@Override
	public TrainerModel updateTrainer(TrainerModel trainerModel) {
		/*
		 * TrainerModel result = null; Query query = new Query();
		 * query.addCriteria(Criteria.where("trainerId").is(trainerModel.getTrainerId())
		 * );
		 * 
		 * Update update = new Update(); update.set("lastUpdatedDate", new Date());
		 * 
		 * if (trainerModel.getAbout() != null && trainerModel.getAbout() != "")
		 * update.set("about", trainerModel.getAbout());
		 * 
		 * if (trainerModel.getAchievements() != null) update.set("achievements",
		 * trainerModel.getAchievements());
		 * 
		 * if (trainerModel.getAddress() != null) update.set("address",
		 * trainerModel.getAddress());
		 * 
		 * if (trainerModel.getAdminStatus() != null && trainerModel.getAdminStatus() !=
		 * "") update.set("adminStatus", trainerModel.getAdminStatus());
		 * 
		 * if (trainerModel.getCategory() != null) update.set("category",
		 * trainerModel.getCategory());
		 * 
		 * if (trainerModel.getCertification() != null) update.set("certification",
		 * trainerModel.getCertification());
		 * 
		 * if (trainerModel.getFirstName() != null && trainerModel.getFirstName() != "")
		 * update.set("firstName", trainerModel.getFirstName());
		 * 
		 * if (trainerModel.getGender() != null && trainerModel.getGender() != "")
		 * update.set("gender", trainerModel.getGender());
		 * 
		 * if (trainerModel.getIsNutritionist() != null) update.set("isNutritionist",
		 * trainerModel.getIsNutritionist());
		 * 
		 * if (trainerModel.getLastName() != null && trainerModel.getLastName() != "")
		 * update.set("lastName", trainerModel.getLastName());
		 * 
		 * if (trainerModel.getProfileImage() != null) update.set("profileImage",
		 * trainerModel.getProfileImage());
		 * 
		 * if (trainerModel.getProfileIntroVideo() != null)
		 * update.set("profileIntroVideo", trainerModel.getProfileIntroVideo());
		 * 
		 * if (trainerModel.getProfileStatus() != null &&
		 * trainerModel.getProfileStatus() != "") update.set("profileStatus",
		 * trainerModel.getProfileStatus());
		 * 
		 * if (trainerModel.getRegistraionType() != null &&
		 * trainerModel.getRegistraionType() != "") update.set("registrationType",
		 * trainerModel.getRegistraionType());
		 * 
		 * if (trainerModel.getServiceOffered() != null) update.set("serviceOffered",
		 * trainerModel.getServiceOffered());
		 * 
		 * if (trainerModel.getTrainerSocialAccounts() != null)
		 * update.set("trainerSocialAccounts", trainerModel.getTrainerSocialAccounts());
		 * 
		 * if (trainerModel.getTrainerTimezone() != null &&
		 * trainerModel.getTrainerTimezone() != "") update.set("trainerTimezone",
		 * trainerModel.getTrainerTimezone());
		 * 
		 * if (trainerModel.getTrainerUserName() != null &&
		 * trainerModel.getTrainerUserName() != "") update.set("trainerUserName",
		 * trainerModel.getTrainerUserName());
		 * 
		 * if (trainerModel.getTrainingSince() != null) update.set("trainingSince",
		 * trainerModel.getTrainingSince());
		 * 
		 * if (trainerModel.getPhoneNumber() != null) update.set("phoneNumber",
		 * trainerModel.getPhoneNumber());
		 * 
		 * if (trainerModel.getIsBusinessDetailsSubmitted() != false)
		 * update.set("isBusinessDetailsSubmitted",
		 * trainerModel.getIsBusinessDetailsSubmitted());
		 * 
		 * this.mongoTemplate.updateFirst(query, update, TrainerModel.class); result =
		 * mongoTemplate.findOne(query, TrainerModel.class);
		 * return result;
		 */
		

		TrainerModel result = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("trainerId").is(trainerModel.getTrainerId()));
		TrainerModel retrivedTrainer = this.mongoTemplate.findOne(query, TrainerModel.class);
		if(retrivedTrainer != null){
		Update update = new Update();
		update.set("lastUpdatedDate", new Date());

		if (trainerModel.getAbout() != null && trainerModel.getAbout() != "")
			update.set("about", trainerModel.getAbout());

		if (trainerModel.getAchievements() != null)
			update.set("achievements", trainerModel.getAchievements());

		if (trainerModel.getAddress() != null)
			update.set("address", trainerModel.getAddress());

		if (trainerModel.getAdminStatus() != null && trainerModel.getAdminStatus() != "")
			update.set("adminStatus", trainerModel.getAdminStatus());

		if (trainerModel.getCategory() != null)
			update.set("category", trainerModel.getCategory());

		if (trainerModel.getCertification() != null)
			update.set("certification", trainerModel.getCertification());

		if (trainerModel.getFirstName() != null && trainerModel.getFirstName() != "")
			update.set("firstName", trainerModel.getFirstName());

		if (trainerModel.getGender() != null && trainerModel.getGender() != "")
			update.set("gender", trainerModel.getGender());

		if (trainerModel.getIsNutritionist() != null)
			update.set("isNutritionist", trainerModel.getIsNutritionist());

		if (trainerModel.getLastName() != null && trainerModel.getLastName() != "")
			update.set("lastName", trainerModel.getLastName());

		if (trainerModel.getProfileImage() != null)
			update.set("profileImage", trainerModel.getProfileImage());

		if (trainerModel.getProfileIntroVideo() != null)
			update.set("profileIntroVideo", trainerModel.getProfileIntroVideo());

		if (trainerModel.getProfileStatus() != null && trainerModel.getProfileStatus() != "")
			update.set("profileStatus", trainerModel.getProfileStatus());

		if (trainerModel.getRegistraionType() != null && trainerModel.getRegistraionType() != "")
			update.set("registrationType", trainerModel.getRegistraionType());

		if (trainerModel.getServiceOffered() != null)
			update.set("serviceOffered", trainerModel.getServiceOffered());

		if (trainerModel.getTrainerSocialAccounts() != null)
			update.set("trainerSocialAccounts", trainerModel.getTrainerSocialAccounts());

		if (trainerModel.getTrainerTimezone() != null && trainerModel.getTrainerTimezone() != "")
			update.set("trainerTimezone", trainerModel.getTrainerTimezone());

		if (trainerModel.getTrainerUserName() != null && trainerModel.getTrainerUserName() != "")
			update.set("trainerUserName", trainerModel.getTrainerUserName());

		if (trainerModel.getTrainingSince() != null)
			update.set("trainingSince", trainerModel.getTrainingSince());

		if (trainerModel.getPhoneNumber() != null)
			update.set("phoneNumber", trainerModel.getPhoneNumber());

		if (trainerModel.getIsBusinessDetailsSubmitted() != false)
			update.set("isBusinessDetailsSubmitted", trainerModel.getIsBusinessDetailsSubmitted());
		
		if (trainerModel.getSpecializedIn() != null)
			update.set("specializedIn", trainerModel.getSpecializedIn());

		this.mongoTemplate.updateFirst(query, update, TrainerModel.class);
		result = mongoTemplate.findOne(query, TrainerModel.class);
		}else{
			List<Category> categoryList = new ArrayList<Category>();
			Category CategoryObj = new Category();
			CategoryObj.setCategory_name("Yoga");
			CategoryObj.setPrimary(false);
			categoryList.add(CategoryObj);
			trainerModel.setCategory(categoryList);
			trainerModel.setAdminStatus("New");
			trainerModel.setLastUpdatedDate(new Date());
			trainerModel.setCreationDate(new Date());
			result = this.mongoTemplate.save(trainerModel, "yoga_trainers");
			Query query2 = new Query();
			query2.addCriteria(Criteria.where("trainerId").in(trainerModel.getTrainerId()));
			Update update2 = new Update();
			update2.set("adminStatus", Constants.PROGRAM_UNDEREVIEW);
			this.mongoTemplate.updateFirst(query2, update2, "trainers");
			
				
		}

		return result;

		
	}

	@Override
	public TrainerModel getTrainerByUserName(String userName) {
		TrainerModel result = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("trainerUserName").is(userName));
		result = mongoTemplate.findOne(query, TrainerModel.class);
		return result;
	}

	@Override
	public List<TrainerModel> getAllTrainers(String ids) {
		List<TrainerModel> result = null;
		String[] array = ids.split(",");
		List<String> list = new ArrayList<String>(Arrays.asList(array));
		Query query = new Query();
		query.addCriteria(Criteria.where("trainerId").in(list));

		result = mongoTemplate.find(query, TrainerModel.class);

		return result;
	}

	@Override
	public List<TrainerModel> getTrainers() {
		Query query = new Query();
		query.addCriteria(Criteria.where("adminStatus").is("Approved"));
		query.fields().include("trainerId");
		query.fields().include("firstName");
		query.fields().include("lastName");
		query.fields().include("address");
		query.fields().include("profileImage");
		query.fields().include("profileIntroVideo");
		return mongoTemplate.find(query, TrainerModel.class);
	}

	@Override
	public List<TraineeModel> getTrainees(String trainee_ids) {
		List<TraineeModel> result = null;
		String[] array = trainee_ids.split(",");
		List<String> list = new ArrayList<String>(Arrays.asList(array));
		Query query = new Query();
		query.addCriteria(Criteria.where("trainee_id").in(list));
		return mongoTemplate.find(query, TraineeModel.class);
	}

	@Override
	public void saveDateModel(TestDateModel test) {
		mongoTemplate.save(test);
	}

	@Override
	public TrainerModel saveTrainer(TrainerModel trainerModel) {
		Criteria criteria = new Criteria();
		criteria.orOperator(Criteria.where("trainerId").is(trainerModel.getTrainerId()),
				Criteria.where("trainerUserName").is(trainerModel.getTrainerUserName()));
		Query query = new Query(criteria);

		TrainerModel result = mongoTemplate.findOne(query, TrainerModel.class);

		if (result == null)
			return mongoTemplate.save(trainerModel);
		else
			return null;
	}

	@Override
	public List<TrainerModel> getTrainersWithPagination(int pagesize, int pagenumber) {
		Pageable pageable = PageRequest.of(pagenumber, pagesize);
		Query query = new Query().with(pageable);
		query.addCriteria(Criteria.where("adminStatus").is("Approved"));
		query.fields().include("trainerId");
		query.fields().include("firstName");
		query.fields().include("lastName");
		query.fields().include("address");
		query.fields().include("profileImage");
		query.fields().include("profileIntroVideo");
		return mongoTemplate.find(query, TrainerModel.class);
	}

	

	@Override
	public void deleteById(String trainerId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("trainerId").is(trainerId));
		this.mongoTemplate.remove(query, TrainerModel.class);
	}

	@Override
	public List<TrainerModel> getAllTrainersByUserName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainerModel> getAllTrainersByCategory(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
