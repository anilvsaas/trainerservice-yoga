package com.yoga.trainerserviceyoga.repo;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.yoga.trainerserviceyoga.model.CalendarModel;
import com.yoga.trainerserviceyoga.model.Constants;
import com.yoga.trainerserviceyoga.model.ProgramModel;

@Repository
public class CalendarImpl implements Calendar {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void updateCalendar(CalendarModel updateCalendar) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(updateCalendar.getCalendarId()));

		Update update = new Update();
		update.set("lastUpdatedDate", new Date());

		if (updateCalendar.getWeeks() != null)
			update.set("weeks", updateCalendar.getWeeks());

		if (updateCalendar.getEndDate() != null)
			update.set("endDate", updateCalendar.getEndDate());

		if (updateCalendar.getIdleFor() != null)
			update.set("idleFor", updateCalendar.getIdleFor());

		if (updateCalendar.getProgramId() != null && updateCalendar.getProgramId() != "")
			update.set("programId", updateCalendar.getProgramId());

		if (updateCalendar.getStartDate() != null)
			update.set("startDate", updateCalendar.getStartDate());

		if (updateCalendar.getTrainerId() != null && updateCalendar.getTrainerId() != "")
			update.set("trainerId", updateCalendar.getTrainerId());

		if (updateCalendar.getAdminStatus() != null)
			update.set("adminStatus", updateCalendar.getAdminStatus());

		this.mongoTemplate.updateFirst(query, update, CalendarModel.class);

	}

	@Override
	public CalendarModel getCalendarByProgramId(String programId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("programId").is(programId));
		return this.mongoTemplate.findOne(query, CalendarModel.class);
	}

	@Override
	public void updateCalendarDependencies(CalendarModel calendar) {
		// First update all workouts associated with exercises

		// String calendarStatus = calendar.getAdminStatus();

//		Query programquery = new Query();
//		programquery.addCriteria(Criteria.where("trainerId").is(calendarModel.getTrainerId())
//				.andOperator(Criteria.where("programId").is(calendarModel.getProgramId())));
//
//		CalendarModel calendar = this.mongoTemplate.findOne(programquery, CalendarModel.class);

//		List<CalendarWeek> weeks = calendar.getWeeks();
//		for (int j = 0; j < weeks.size(); j++) {
//			List<CalendarDay> days = weeks.get(j).getDays();
//			for (int k = 0; k < days.size(); k++) {
//				List<WorkoutCalendarReference> workouts = days.get(k).getWorkouts();
//
//				if (workouts != null) {
//					for (int l = 0; l < workouts.size(); l++) {
//
//						WorkoutCalendarReference calendarWorkout = workouts.get(l);
//
//						List<ExerciseModel> calendarWorkoutExercises = calendarWorkout.getWorkoutExercises();
//
//						for (int m = 0; m < calendarWorkoutExercises.size(); m++) {
//							ExerciseModel exercise = calendarWorkoutExercises.get(m);
//							if (calendar.getAdminStatus() != null
//									&& calendarStatus.equals(Constants.PROGRAM_REJECTED)) {
//								exercise.setAdminStatus(Constants.PROGRAM_UNDEREVIEW);
//							}
//						}
//						if (calendar.getAdminStatus() != null && calendarStatus.equals(Constants.PROGRAM_REJECTED)) {
//							calendarWorkout.setAdminStatus(Constants.PROGRAM_UNDEREVIEW);
//						}
//
//					}
//				}
//
//			}
//		}
//		if (calendar.getAdminStatus() != null && calendarStatus.equals(Constants.PROGRAM_REJECTED)) {
//			calendar.setAdminStatus(Constants.PROGRAM_UNDEREVIEW);
//		}

		Query programQuery = new Query();
		programQuery.addCriteria(Criteria.where("trainerId").is(calendar.getTrainerId()));
		programQuery.addCriteria(Criteria.where("programId").is(calendar.getProgramId()));

		Update calendarUpdate = new Update();

		if (calendar.getAdminStatus() != null) {
			calendarUpdate.set("adminStatus", Constants.PROGRAM_UNDEREVIEW);
			mongoTemplate.updateFirst(programQuery, calendarUpdate, ProgramModel.class);
			mongoTemplate.updateFirst(programQuery, calendarUpdate, CalendarModel.class);
		}

		// calendarUpdate.set("weeks", weeks);

	}

	@Override
	public void saveCalendar(CalendarModel calendarModel) {
		this.mongoTemplate.save(calendarModel);
	}

	@Override
	public void deleteById(String calendarId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(calendarId));
		this.mongoTemplate.remove(query, CalendarModel.class);
	}

}
