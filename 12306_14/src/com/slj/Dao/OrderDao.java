package com.slj.Dao;

import java.util.List;

import com.slj.model.Ticket;

public interface OrderDao {
	public boolean addOrder(int orderid, int ticketid);
	
	public List<Ticket> findTicketByOrderId(int orderid);
	
	public void deleteOrder(int orderid,int ticketid);

}
