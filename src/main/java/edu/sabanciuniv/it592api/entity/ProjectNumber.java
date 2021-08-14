package edu.sabanciuniv.it592api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class ProjectNumber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private int number;
	
	@OneToMany(mappedBy = "mainProject")
	private Set<ProjectNumber> subProjects = new HashSet<>();
	
	@ManyToOne(cascade={CascadeType.ALL})
	private ProjectNumber mainProject;
	
	@ManyToOne
	private Project project;
	
	public ProjectNumber() {	}
}
