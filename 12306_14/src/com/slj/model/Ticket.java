package com.slj.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

@Entity
@Table(name="ticket3")
public class Ticket {
	
	private 	int id; 
	private String name;
	private String startstation;
	private String endstation;
	private Timestamp endtime;
	private Timestamp starttime;
	private int num;
	private String stations;
	
	
	public String getStations() {
		return stations;
	}
	public void setStations(String stations) {
		this.stations = stations;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartstation() {
		return startstation;
	}
	public void setStartstation(String startstation) {
		this.startstation = startstation;
	}
	public String getEndstation() {
		return endstation;
	}
	public void setEndstation(String endstation) {
		this.endstation = endstation;
	}
	
	public Timestamp getEndtime() {
		System.out.println(this.endstation);
		return endtime;
	}
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public int getNum() {
		System.out.println(this.num);

		return num;
	}
	
	public void setNum(int num) {
		System.out.println("before do set num");
		this.num = (int)num;
		System.out.println(this.num);
	}

}
