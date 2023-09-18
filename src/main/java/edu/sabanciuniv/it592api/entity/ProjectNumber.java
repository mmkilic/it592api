package edu.sabanciuniv.it592api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToOne
	@JoinColumn(name="main_project_id")
	private ProjectNumber mainProject;
	
	@JsonIgnore
	@OneToMany(mappedBy = "mainProject", cascade=CascadeType.REMOVE)
	private Set<ProjectNumber> subProjects = new HashSet<>();
	
	@JsonIgnore
	@OneToOne(mappedBy = "projectNumber", orphanRemoval = true)
	private Project project;
	
	public ProjectNumber() {	}
}
