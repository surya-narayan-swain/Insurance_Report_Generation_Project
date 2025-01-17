package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.CitizenPlan;

public interface ICitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {

	 //distinct is a query used to retrieve unique records
	  
	  @Query("select distinct (planName) from CitizenPlan")
	  public List<String> getPlanName();
	  
	  @Query("select distinct (planStatus) from CitizenPlan")
	  public List<String>  getPlanStatus();
	 
}
