package com.yoga.trainerserviceyoga.repo;

import java.util.List;

import com.yoga.trainerserviceyoga.childmodel.TrainerSlot;
import com.yoga.trainerserviceyoga.model.MealplanModel;
import com.yoga.trainerserviceyoga.model.ProgramModel;
import com.yoga.trainerserviceyoga.model.SubscriptionModel;

public interface Reports {
	List<SubscriptionModel>  getSubscriptions(String programId,String selection);
	List<ProgramModel> getProgramstatus(String trainerId, String selection);
	MealplanModel gettraineemealplan(String program_id, String trainee_id, String string);
	List<TrainerSlot> getTrainerslots(String trainerId,String monthname,String calltype);
}
