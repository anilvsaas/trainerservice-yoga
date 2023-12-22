package com.yoga.trainerserviceyoga.repo;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.mongodb.client.FindIterable;
import com.yoga.trainerserviceyoga.childmodel.WorkoutHistoryModel;
import com.yoga.trainerserviceyoga.model.AsanaHistoryModel;
import com.yoga.trainerserviceyoga.model.CalendarModel;
import com.yoga.trainerserviceyoga.model.Constants;
import com.yoga.trainerserviceyoga.model.MealplanModel;
import com.yoga.trainerserviceyoga.model.ProgramModel;
import com.yoga.trainerserviceyoga.model.SubscriptionModel;
import com.yoga.trainerserviceyoga.model.TraineeCalendarModel;
import com.yoga.trainerserviceyoga.model.TraineeModel;
import com.yoga.trainerserviceyoga.model.TraineeProgressphoto;

@Repository
public class ProgramImpl implements Program {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void updateProgram(ProgramModel programModel) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(programModel.getProgramId()));
		Update update = new Update();
		update.set("lastUpdateOn", programModel.getLastUpdateOn());
		update.set("priceInRupees", programModel.getPriceInRupees());
		update.set("priceInDollars", programModel.getPriceInDollars());

		if (programModel.getAdminStatus() != null && programModel.getAdminStatus() != "")
			update.set("adminStatus", programModel.getAdminStatus());

		if (programModel.getTrainingDays() != null)
			update.set("trainingDays", programModel.getTrainingDays());
		
		if (programModel.getNumberOfSlots() != 0)
			update.set("numberOfSlots", programModel.getNumberOfSlots());
		
		if (programModel.getSlots() != null)
			update.set("slots", programModel.getSlots());

		if (programModel.getDescription() != null && programModel.getDescription() != "")
			update.set("description", programModel.getDescription());

		if (programModel.getEnrollmentDate() != null)
			update.set("enrollmentDate", programModel.getEnrollmentDate());

		if (programModel.getNutrition() != null)
			update.set("nutrition", programModel.getNutrition());

		if (programModel.getPackageType() != null)
			update.set("packageType", programModel.getPackageType());

		if (programModel.getPlans() != null)
			update.set("plans", programModel.getPlans());

		if (programModel.getProgramAddons() != null)
			update.set("programAddons", programModel.getProgramAddons());

		if (programModel.getProgramDuration() != null)
			update.set("programDuration", programModel.getProgramDuration());

		if (programModel.getProgramImage() != null)
			update.set("programImage", programModel.getProgramImage());

		if (programModel.getProgramName() != null && programModel.getProgramName() != "")
			update.set("programName", programModel.getProgramName());

		if (programModel.getStartDate() != null)
			update.set("startDate", programModel.getStartDate());

		if (programModel.getStatus() != null && programModel.getStatus() != "")
			update.set("status", programModel.getStatus());

		if (programModel.getTrainerId() != null && programModel.getTrainerId() != "")
			update.set("trainerId", programModel.getTrainerId());

		if (programModel.getWeeks() != null)
			update.set("weeks", programModel.getWeeks());

		if (programModel.getMaxBmi() != null)
			update.set("maxBmi", programModel.getMaxBmi());

		if (programModel.getEndDate() != null)
			update.set("endDate", programModel.getEndDate());

		if (programModel.getEnrollmentEndDate() != null)
			update.set("enrollmentEndDate", programModel.getEnrollmentEndDate());

		if (programModel.getProgramType() != null)
			update.set("programType", programModel.getProgramType());
		
		if (programModel.getExternalCallLink() != null)
			update.set("externalCallLink", programModel.getExternalCallLink());

		this.mongoTemplate.updateFirst(query, update, ProgramModel.class);

		if (programModel.getAdminStatus() != null
				&& programModel.getAdminStatus().equals(Constants.PROGRAM_UNDEREVIEW)) {
			Query cal_query = new Query();
			cal_query.addCriteria(Criteria.where("programId").is(programModel.getProgramId()));
			Update cal_update = new Update();
			cal_update.set("adminStatus", Constants.PROGRAM_UNDEREVIEW);
			this.mongoTemplate.updateFirst(cal_query, cal_update, CalendarModel.class);
		}

	}

	@Override
	public List<ProgramModel> getAllProgramsByTrainerId(String trainerId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("trainerId").is(trainerId));
		return this.mongoTemplate.find(query, ProgramModel.class);
	}

	@Override
	public TraineeModel getTrainee(String trainee_id, String program_id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("trainee_id").is(trainee_id));
		TraineeModel trainee = mongoTemplate.findOne(query, TraineeModel.class);
		query.addCriteria(Criteria.where("program_id").is(program_id));
		SubscriptionModel sub = mongoTemplate.findOne(query, SubscriptionModel.class);
		trainee.setIsProgramActive(sub.getIsProgramActive());
		return trainee;
	}

	@Override
	public List<TraineeModel> getAllTraineesByProgram(String program_id, String type) {

		Query query = new Query();
		query.addCriteria(Criteria.where("program_id").is(program_id));
		if (!type.equals("all")) {
			query.addCriteria(Criteria.where("isProgramActive").is(true));
		}
		query.fields().include("trainee_id");
		query.fields().include("isProgramActive");
		List<SubscriptionModel> subscriptions = mongoTemplate.find(query, SubscriptionModel.class);
		List<String> trainee_ids = new ArrayList<>();
		for (SubscriptionModel subscription : subscriptions) {
			trainee_ids.add(subscription.getTrainee_id());
		}
		Query query1 = new Query();
		query1.addCriteria(Criteria.where("trainee_id").in(trainee_ids));
		List<TraineeModel> trainees = mongoTemplate.find(query1, TraineeModel.class);
		for (TraineeModel trainee : trainees) {
			Optional<SubscriptionModel> sub = subscriptions.stream()
					.filter(subscription -> subscription.getTrainee_id().equals(trainee.getTrainee_id())).findFirst();
			trainee.setIsProgramActive(sub.get().getIsProgramActive());
		}
		return trainees;
	}

	@Override
	public TraineeCalendarModel getTraineeCalendar(String program_id, String trainee_id) {
		TraineeCalendarModel result = null;
		Query p_query =  new Query();
		p_query.addCriteria(Criteria.where("programId").is(program_id));
		ProgramModel pmodel =  this.mongoTemplate.findOne(p_query, ProgramModel.class);	
		if(pmodel.getIsContentProgram()) {
		Query query = new Query();
		query.addCriteria(Criteria.where("trainee_id").is(trainee_id));
		query.addCriteria(Criteria.where("program_id").is(program_id));
		result = mongoTemplate.findOne(query, TraineeCalendarModel.class);
		SubscriptionModel subscription = mongoTemplate.findOne(query, SubscriptionModel.class);
		result.setSubscriptionDate(subscription.getSubscription_date());
		}
		return result;
	}

	@Override
	public List<TraineeProgressphoto> getAllProgressPhotos(String trainee_id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("trainee_id").is(trainee_id)).with(Sort.by(Sort.Order.asc("date")));
		return mongoTemplate.find(query, TraineeProgressphoto.class);
	}

	@Override
	public List<TraineeProgressphoto> getProgressPhotosByDate(Date fromDate, Date toDate, String trainee_id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("trainee_id").is(trainee_id));
		query.addCriteria(Criteria.where("date").gte(fromDate).lte(toDate)).with(Sort.by(Sort.Order.asc("date")));
		List<TraineeProgressphoto> progressPhotos = mongoTemplate.find(query, TraineeProgressphoto.class);
		return progressPhotos;

	}

	@Override
	public void delteCalendarByProgramId(String programId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("programId").is(programId));
		this.mongoTemplate.remove(query, CalendarModel.class);
	}

	@Override
	public List<ProgramModel> getAllProgramsWithPagination(String trainer_id, int pagesize, int pagenumber) {
		Pageable pageable = PageRequest.of(pagenumber, pagesize);
		Query query = new Query().with(pageable);
		query.addCriteria(Criteria.where("trainerId").is(trainer_id));
		return this.mongoTemplate.find(query, ProgramModel.class);
	}

	@Override
	public List<TraineeCalendarModel> getTraineeAsanaHistory(AsanaHistoryModel request) {
		Query query = new Query();
		Criteria criteria1 = new Criteria();
		criteria1.andOperator(Criteria.where("startDate").gte(request.getStartDate()),
				Criteria.where("startDate").lte(request.getEndDate()));
		Criteria criteria2 = new Criteria();
		criteria2.andOperator(Criteria.where("endDate").gte(request.getStartDate()),
				Criteria.where("endDate").lte(request.getEndDate()));
		Criteria criteria = new Criteria();
		criteria.orOperator(criteria1, criteria2);
		query.addCriteria(criteria);

		query.addCriteria(Criteria.where("trainee_id").is(request.getTrainee_id()));
		query.addCriteria(Criteria.where("trainer_id").is(request.getTrainerId()));
		query.addCriteria(Criteria.where("trainer_status").is("published"));

//		query.addCriteria(Criteria.where("startDate").gte(startDate).lte(endDate).orOperator(Criteria.where("endDate").gte(startDate).lte(endDate)));
		System.out.println(query);
		List<TraineeCalendarModel> trainee_calendars = this.mongoTemplate.find(query, TraineeCalendarModel.class);
		return trainee_calendars;
	}

	@Override
	public List<MealplanModel> getTraineeMealplanHistory(AsanaHistoryModel request) {
		Query query = new Query();
		Criteria criteria1 = new Criteria();
		criteria1.andOperator(Criteria.where("startDate").gte(request.getStartDate()),
				Criteria.where("startDate").lte(request.getEndDate()));
		Criteria criteria2 = new Criteria();
		criteria2.andOperator(Criteria.where("endDate").gte(request.getStartDate()),
				Criteria.where("endDate").lte(request.getEndDate()));
		Criteria criteria = new Criteria();
		criteria.orOperator(criteria1, criteria2);
		query.addCriteria(criteria);

		query.addCriteria(Criteria.where("trainee_id").is(request.getTrainee_id()));
		query.addCriteria(Criteria.where("trainer_id").is(request.getTrainerId()));

		List<MealplanModel> mealplans = this.mongoTemplate.find(query, MealplanModel.class);

		return mealplans;
	}

	@Override
	public ProgramModel findById(String programId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("programId").is(programId));
		return this.mongoTemplate.findOne(query, ProgramModel.class);
	}

	@Override
	public void deleteById(String programId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("programId").is(programId));
		this.mongoTemplate.remove(query, ProgramModel.class);
	}

	@Override
	public ProgramModel saveProgram(ProgramModel programModel) {
		return this.mongoTemplate.save(programModel);
	}
}
