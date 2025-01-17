package com.nt.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Citizen_plan")
public class CitizenPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
	@SequenceGenerator(name = "id_sequence", sequenceName = "mysql_insurance02_sequence_id")
	private Integer citizenId;
	private String citizenName;
	private String planName;
	private String planStatus;
	private String gender;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double benefitAmount;
	private String denielReason;
	private LocalDate terminate;
	private String terminatedReason;
}
