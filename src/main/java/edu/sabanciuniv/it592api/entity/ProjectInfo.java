package edu.sabanciuniv.it592api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class ProjectInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
    public int powerOnan;
    public int powerOnaf;
    public int lowVoltage;
    public int highVoltage;
    public String customerName;
    public String productType;
    public String industrialModel;
    
    @ManyToOne
    public User projectManger;
    
    @JsonIgnore
    @OneToOne (mappedBy = "projectInfo", orphanRemoval = true)
	private Project project;
    
    public ProjectInfo() {	}
}
