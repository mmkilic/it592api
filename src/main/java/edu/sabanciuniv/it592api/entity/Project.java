package edu.sabanciuniv.it592api.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@OneToOne(cascade = {CascadeType.REMOVE})
	@JoinColumn(name = "project_number_id")
	private ProjectNumber projectNumber;
	
	@OneToOne(cascade = CascadeType.REMOVE)
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
	
	@Transient
	@Enumerated(EnumType.STRING)
	private Statuses status;
	@Transient
	private int expiryGa;
	@Transient
	private int expiryBom;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate createdDate;
	@ManyToOne
	private User creator;
	
	public Project() {	}
	
}
