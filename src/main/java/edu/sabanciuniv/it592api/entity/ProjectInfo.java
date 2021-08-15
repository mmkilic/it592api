package edu.sabanciuniv.it592api.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @OneToOne
    public User projectManger;
    public String projectName;
    public String customerName;
    public String endUserCountry;
    public String productType;
    public String industrialModel;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate createDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate drwaingReleaseDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate invoiceDate;
    
    @OneToOne (mappedBy = "projectInfo")
	private Project project;
    
    public ProjectInfo() {	}
}
