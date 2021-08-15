package edu.sabanciuniv.it592api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.sabanciuniv.it592api.enums.Statuses;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(mappedBy = "project")
	private List<ProjectNumber> projectNumbers = new ArrayList<>();
	@OneToOne 
	private ProjectInfo projectInfo;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate gaElectPlan;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate gaElectActual;
	@ManyToOne
	private User gaElectDesigner;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate gaMechPlan;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate gaMechActual;
	@ManyToOne
	private User gaMechDesigner;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate gaControlPlan;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate gaControlActual;
	@ManyToOne
	private User gaControlerDesigner;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate gaDeadlinePlan;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate gaDeadlineActual;
	@Transient
	@Setter(AccessLevel.PRIVATE)
	private User gaDeadlineDesigner;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate approvalPlan;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate approvalActual;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bomElectPlan;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bomElectActual;
	@ManyToOne
	private User bomElectDesigner;
    
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bomMechPlan;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bomMechActual;
	@ManyToOne
	private User bomMechDesigner;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bomControlPlan;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bomControlActual;
	@ManyToOne
	private User bomControlDesigner;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bomDeadlinePlan;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bomDeadlineActual;
	@Transient
	@Setter(AccessLevel.PRIVATE)
	private User bomDeadlineDesigner;
	
	@Enumerated(EnumType.STRING)
	private Statuses status;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDateTime createdDate;
	@ManyToOne
	private User creator;
	
	public Project() {	}
	
	public User getGaDeadlineDesigner(){
		return gaDeadlineDesigner = gaMechDesigner;
	}
	public User getBomDeadlineDesigner(){
		return bomDeadlineDesigner = bomMechDesigner;
	}
}
