package com.nt.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CitizenPlan;
import com.nt.repository.ICitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	private ICitizenPlanRepository citizenrepo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		citizenrepo.deleteAll();
		CitizenPlan cp=new CitizenPlan();
		cp.setCitizenName("john");
		cp.setGender("male");
		cp.setPlanName("cash");
		cp.setPlanStatus("approved");
		cp.setStartDate(LocalDate.now());
		cp.setEndDate(LocalDate.now().plusMonths(6));
		cp.setBenefitAmount(5000.0);
		
		CitizenPlan cp1=new CitizenPlan();
		cp1.setCitizenName("nick");
		cp1.setGender("male");
		cp1.setPlanName("food");
		cp1.setPlanStatus("approved");
		cp1.setStartDate(LocalDate.now());
		cp1.setEndDate(LocalDate.now().plusMonths(5));
		cp1.setBenefitAmount(4600.0);
		
		CitizenPlan cp2=new CitizenPlan();
		cp2.setCitizenName("orlen");
		cp2.setGender("female");
		cp2.setPlanName("car");
		cp2.setPlanStatus("denial");
		cp2.setDenielReason("employed");
		
		CitizenPlan cp3=new CitizenPlan();
		cp3.setCitizenName("david");
		cp3.setGender("male");
		cp3.setPlanName("cash");
		cp3.setPlanStatus("terminated");
		cp3.setStartDate(LocalDate.now());
		cp3.setEndDate(LocalDate.now().plusMonths(6));
		cp3.setBenefitAmount(5000.0);
		cp3.setTerminate(LocalDate.now().plusMonths(1));
		cp3.setTerminatedReason("rental income");
		
		CitizenPlan cp4=new CitizenPlan();
		cp4.setCitizenName("smith");
		cp4.setGender("male");
		cp4.setPlanName("food");
		cp4.setPlanStatus("denial");
		cp4.setDenielReason("property income");
		
		CitizenPlan cp5=new CitizenPlan();
		cp5.setCitizenName("sam");
		cp5.setGender("male");
		cp5.setPlanName("cash");
		cp5.setPlanStatus("approved");
		cp5.setStartDate(LocalDate.now());
		cp5.setEndDate(LocalDate.now().plusMonths(8));
		cp5.setBenefitAmount(25000.0);
		
		CitizenPlan cp6=new CitizenPlan();
		cp6.setCitizenName("steve");
		cp6.setGender("male");
		cp6.setPlanName("food");
		cp6.setPlanStatus("terminated");
		cp6.setStartDate(LocalDate.now());
		cp6.setEndDate(LocalDate.now().plusMonths(6));
		cp6.setBenefitAmount(15000.0);
		cp6.setTerminate(LocalDate.now().plusMonths(2));
		cp6.setTerminatedReason("salary");
		
		CitizenPlan cp7=new CitizenPlan();
		cp7.setCitizenName("shanu");
		cp7.setGender("male");
		cp7.setPlanName("car");
		cp7.setPlanStatus("denial");
		cp7.setStartDate(LocalDate.now());
		cp7.setEndDate(LocalDate.now().plusMonths(10));
		cp7.setBenefitAmount(2000.0);
		
		CitizenPlan cp9=new CitizenPlan();
		cp9.setCitizenName("jack");
		cp9.setGender("male");
		cp9.setPlanName("food");
		cp9.setPlanStatus("denial");
		cp9.setDenielReason("salary");
		
		CitizenPlan cp8=new CitizenPlan();
		cp8.setCitizenName("stoke");
		cp8.setGender("male");
		cp8.setPlanName("cash");
		cp8.setPlanStatus("approved");
		cp8.setStartDate(LocalDate.now());
		cp8.setEndDate(LocalDate.now().plusMonths(12));
		cp8.setBenefitAmount(23000.0);
		
		List<CitizenPlan> list = Arrays.asList(cp1,cp2,cp3,cp4,cp4,cp5,cp6,cp7,cp8);
		citizenrepo.saveAll(list);
	}

}
