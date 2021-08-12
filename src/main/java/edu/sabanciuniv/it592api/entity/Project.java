package edu.sabanciuniv.it592api.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@OneToOne
	private ProjectInfo projectInfo;

	private LocalDateTime gaElectPlan;
	private LocalDateTime gaElectActual;
	@ManyToOne
	private User gaElectDesigner;
	
	private LocalDateTime gaMechPlan;
	private LocalDateTime gaMechActual;
	@ManyToOne
	private User gaMechDesigner;
	
	private LocalDateTime gaControlPlan;
	private LocalDateTime gaControlActual;
	@ManyToOne
	private User gaControlerDesigner;
	
	private LocalDateTime gaDeadlinePlan;
	private LocalDateTime gaDeadlineActual;
	@Transient
	@Getter
	private User gaDeadlineDesigner;
	
	private LocalDateTime approvalPlan;
	private LocalDateTime approvalActual;
	
	private LocalDateTime bomElectPlan;
	private LocalDateTime bomElectActual;
	@ManyToOne
	private User bomElectDesigner;
	
	private LocalDateTime bomWindingPlan;
	private LocalDateTime bomWindingActual;
	@ManyToOne
	private User bomWindingDesigner;
    
	private LocalDateTime bomMechPlan;
	private LocalDateTime bomMechActual;
	@ManyToOne
	private User bomMechDesigner;
	
	private LocalDateTime bomControlPlan;
	private LocalDateTime bomControlActual;
	@ManyToOne
	private User bomControlDesigner;
	
	private LocalDateTime bomDeadlinePlan;
	private LocalDateTime bomDeadlineActual;
	@Transient
	@Getter
	private User bomDeadlineDesigner;
	
	@Enumerated(EnumType.STRING)
	private Statuses status;
	
	private LocalDateTime createdDate;
	@ManyToOne
	private User creator;
	
	public Project() {
		gaDeadlineDesigner = gaMechDesigner;
		bomDeadlineDesigner = bomMechDesigner;
	}
}
