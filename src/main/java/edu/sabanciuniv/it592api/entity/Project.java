package edu.sabanciuniv.it592api.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.sabanciuniv.it592api.enums.Statuses;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private ProjectNumber projectNumber;
	@ManyToOne
	private User elecDesigner;
	@ManyToOne
	private User mechDesigner;
	@OneToOne
	private ProjectInfo projectInfo;
	
	private LocalDateTime gaElectPlan;
	private LocalDateTime gaElectActual;
	
	private LocalDateTime gaMechPlan;
	private LocalDateTime gaMechActual;
	
	private LocalDateTime gaControlPlan;
	private LocalDateTime gaControlActual;
	
	private LocalDateTime gaDeadlinePlan;
	private LocalDateTime gaDeadlineActual;
	
	private LocalDateTime approvalPlan;
	private LocalDateTime approvalActual;
	
	private LocalDateTime bomElectPlan;
	private LocalDateTime bomElectActual;
	
	private LocalDateTime bomWindingPlan;
	private LocalDateTime bomWindingActual;
    
	private LocalDateTime bomMechPlan;
	private LocalDateTime bomMechActual;
	
	private LocalDateTime bomControlPlan;
	private LocalDateTime bomControlActual;
	
	private LocalDateTime bomDeadlinePlan;
	private LocalDateTime bomDeadlineActual;
	
	private Statuses status;
	
	private LocalDateTime createdDate;
	private User creator;
	
}
