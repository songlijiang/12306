package com.slj.service;

import java.util.List;

import com.slj.model.Ticket;
import com.slj.model.User;

public interface TicketService {
 public List<Ticket> listTicket();
 public List<Ticket> listForPage(int pageNow,int pageSize);
 public void buyTicketById(User user, int id);
 public List<Ticket> findTicketByOrderId(User user);
 public void  deleteTicketByTidFromUser(User user, int tid);
 public List<Ticket> searchTicket(String startStation ,String endStation);
}
