package com.yoga.trainerserviceyoga.repo;

import java.util.List;

import com.yoga.trainerserviceyoga.model.TestDateModel;
import com.yoga.trainerserviceyoga.model.TraineeModel;
import com.yoga.trainerserviceyoga.model.TrainerModel;

public interface Trainer {
	public TrainerModel getTrainerById(String trainerId);

	public TrainerModel updateTrainer(TrainerModel trainerModel);

	public TrainerModel getTrainerByUserName(String userName);

	public List<TrainerModel> getAllTrainers(String ids);

	public List<TrainerModel> getTrainers();

	public List<TraineeModel> getTrainees(String trainee_ids);
	
	public void saveDateModel(TestDateModel test);
	
	public TrainerModel saveTrainer(TrainerModel trainerModel);

	public List<TrainerModel> getTrainersWithPagination(int pagesize, int pagenumber);

	public void deleteById(String trainerId);

	public List<TrainerModel> getAllTrainersByUserName(String id);

	public List<TrainerModel> getAllTrainersByCategory(String id);
}
