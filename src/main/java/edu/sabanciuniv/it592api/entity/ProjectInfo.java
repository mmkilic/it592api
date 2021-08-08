package edu.sabanciuniv.it592api.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class ProjectInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
    public double power1;
    public double Power2;
    public double LowVoltage;
    public double highVoltage;
    public String engType;
    public String industrialModel;
    public String pmCode;
    public String pmName;
    public String customer;
    public String customerName;
    public String endUserCountry;
    public String projectName;
    public LocalDateTime drwaingReleaseDate;
    public LocalDateTime createDate;
    
}
