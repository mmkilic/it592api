package edu.sabanciuniv.it592api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private String fullName;
	private String email;
	private String password;
	private Roles role;
	private Departments department;
	private User manager;
	
	@OneToMany
	private List<Project> projects = new ArrayList<>();
}
