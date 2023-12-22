package com.yoga.trainerserviceyoga.repo;

import java.util.List;

import com.yoga.trainerserviceyoga.model.BusinessDetailsModel;



public interface  Businessdetails  {

	BusinessDetailsModel update(BusinessDetailsModel businessdetails);

	List<BusinessDetailsModel> findBytrainerId(String trainerId);

	void saveBusinessDetails(BusinessDetailsModel inputbusinessdetails);

}
