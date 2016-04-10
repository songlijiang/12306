package com.slj.dto;

import java.sql.Timestamp;


public class TicketDTO {
	private 	int id; 
	private String tname;
	private String startstation;
	private String endstation;
	private Timestamp endtime;
	private Timestamp starttime;
	private int orderid;
	private int num;
	private String stations;
	
	
	
	public String getStations() {
		return stations;
	}
	public void setStations(String stations) {
		this.stations = stations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

}
