package edu.sabanciuniv.it592api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private String sesaNo;
	private String firstName;
	private String lastName;
	@Transient
	@Getter
	private String fullName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Roles role;
	@Enumerated(EnumType.STRING)
	private Departments department;
	//private User manager;
	
	@OneToMany(mappedBy = "gaElectDesigner")
	private List<Project> projectsGaElect = new ArrayList<>();
	@OneToMany(mappedBy = "gaMechDesigner")
	private List<Project> projectsGaMech = new ArrayList<>();
	@OneToMany(mappedBy = "gaControlerDesigner")
	private List<Project> projectGaControler = new ArrayList<>();
	@OneToMany(mappedBy = "gaControlerDesigner")
	private List<Project> projectBomElect = new ArrayList<>();
	@OneToMany(mappedBy = "gaControlerDesigner")
	private List<Project> projectBomWinding = new ArrayList<>();
	@OneToMany(mappedBy = "gaControlerDesigner")
	private List<Project> projectBomMech = new ArrayList<>();
	@OneToMany(mappedBy = "gaControlerDesigner")
	private List<Project> projectBomControl = new ArrayList<>();
	@OneToMany(mappedBy = "gaControlerDesigner")
	private List<Project> projectCreator = new ArrayList<>();
	
	public User() {
		fullName = firstName + " " + lastName;
	}
}
