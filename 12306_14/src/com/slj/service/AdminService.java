package com.slj.service;

import com.slj.model.Admin;
import com.slj.model.Ticket;

public interface AdminService {

	
	public String CheckValidOfAdmin(Admin admin);
	public void addTicket(Ticket ticket);
	public void deleteTicketByAdmin(int tid);
}
