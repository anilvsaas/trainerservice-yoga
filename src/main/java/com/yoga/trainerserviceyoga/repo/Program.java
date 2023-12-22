package com.yoga.trainerserviceyoga.repo;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.yoga.trainerserviceyoga.childmodel.WorkoutHistoryModel;
import com.yoga.trainerserviceyoga.model.AsanaHistoryModel;
import com.yoga.trainerserviceyoga.model.MealplanModel;
import com.yoga.trainerserviceyoga.model.ProgramModel;
import com.yoga.trainerserviceyoga.model.TraineeCalendarModel;
import com.yoga.trainerserviceyoga.model.TraineeModel;
import com.yoga.trainerserviceyoga.model.TraineeProgressphoto;

public interface Program {
	public void updateProgram(ProgramModel programModel);

	public List<ProgramModel> getAllProgramsByTrainerId(String trainerId);

	List<TraineeModel> getAllTraineesByProgram(String program_id, String type);

	TraineeModel getTrainee(String trainee_id, String program_id);

	TraineeCalendarModel getTraineeCalendar(String program_id, String trainee_id);

	public List<TraineeProgressphoto> getAllProgressPhotos(String trainee_id);

	public List<TraineeProgressphoto> getProgressPhotosByDate(Date startDate, Date endDate, String trainee_id);

	public void delteCalendarByProgramId(String programId);

	public List<ProgramModel> getAllProgramsWithPagination(String trainer_id, int pagesize, int pagenumber);

	public List<TraineeCalendarModel> getTraineeAsanaHistory(AsanaHistoryModel request);

	public List<MealplanModel> getTraineeMealplanHistory(AsanaHistoryModel request);

	public ProgramModel findById(String programId);

	public void deleteById(String programId);

	public ProgramModel saveProgram(ProgramModel programModel);
	
}
