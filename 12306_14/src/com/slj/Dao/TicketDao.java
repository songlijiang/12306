package com.slj.Dao;

import java.util.List;

import com.slj.model.Ticket;
import com.slj.model.User;

public interface TicketDao {
	
	public List<Ticket> list();
	
	public List<Ticket> listForPage(int pageNow,int pageSize);
	
	public void buyTicketById(int userid,int id);
	
	public List<Ticket> findTicketByOrderId(int orderid);
	
	public Ticket deleteTicketByTid(int tid);

	public void resetOrder(User user,int did);
	
	public List<Ticket> searchTicket(String startStation ,String endStation);

}
