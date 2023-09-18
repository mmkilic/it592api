package edu.sabanciuniv.it592api.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.sabanciuniv.it592api.enums.Departments;
import edu.sabanciuniv.it592api.enums.Roles;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique=true)
	private String companyId;
	private String firstName;
	private String lastName;
	@Transient
	private String fullName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Roles role;
	@Enumerated(EnumType.STRING)
	private Departments department;
	
	@ManyToOne
    @JoinColumn(name="manager_id")
    private User manager;
	@JsonIgnore
    @OneToMany(mappedBy="manager")
    private Set<User> subordinates = new HashSet<User>();
	
	@JsonIgnore
	@OneToMany (mappedBy = "projectManger")
	private List<ProjectInfo> projectInfo = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "gaElectDesigner")
	private List<Project> projectsGaElect = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "gaMechDesigner")
	private List<Project> projectsGaMech = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "bomElectDesigner")
	private List<Project> projectBomElect = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "bomMechDesigner")
	private List<Project> projectBomMech = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "creator")
	private List<Project> projectCreator = new ArrayList<>();
	
	
	public User() {	}
	
	public User(int id) {
		this.id = id;
	}
	
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
}
