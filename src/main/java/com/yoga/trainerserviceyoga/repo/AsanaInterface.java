package com.yoga.trainerserviceyoga.repo;

import java.util.List;

import com.yoga.trainerserviceyoga.model.AsanaModel;

public interface AsanaInterface {

	void saveAsana(AsanaModel asanaModel);

	AsanaModel getAsana(String asanaId);

	void updateAsana(AsanaModel asanaModel);

	void deleteAsana(String asanaId);

	List<AsanaModel> getAllAsanas(String trainerId);

}
