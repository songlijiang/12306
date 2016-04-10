package com.slj.Dao;

import com.slj.model.Admin;
import com.slj.model.Ticket;

public interface AdminDao {
	public boolean CheckLogin(Admin admin);
	public void addTicket(Ticket ticket);
	
	

}
