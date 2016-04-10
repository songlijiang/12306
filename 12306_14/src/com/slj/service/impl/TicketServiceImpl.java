package com.slj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.slj.Dao.TicketDao;
import com.slj.model.Ticket;
import com.slj.model.User;
import com.slj.service.TicketService;
import com.slj.service.UserService;

@Component("ticketServiceImpl")
public class TicketServiceImpl implements TicketService{
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private TicketDao ticketDao ;

	public TicketDao getTicketDao() {
		return ticketDao;
	}

	@Resource(name="ticketDaoImpl")
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public List<Ticket> listTicket() {
		
		return ticketDao.list();
	}

	public void buyTicketById(User user, int id) {
		 int uid =  userService.getIdByname(user);
		 System.out.println("from ticketServicIMPL .buyTicketByID e uid="+uid);
		ticketDao.buyTicketById(uid, id);
		
	}
	public List<Ticket> findTicketByOrderId(User user) {
		int orderid = userService.getIdByname(user);
		return ticketDao.findTicketByOrderId(orderid);
	}
	public void deleteTicketByTidFromUser(User user, int tid) {
		
		ticketDao.resetOrder(user, tid);
		
	}
	@Override
	public List<Ticket> searchTicket(String startStation, String endStation) {
		return ticketDao.searchTicket(startStation, endStation);
	}
	@Override
	public List<Ticket> listForPage(int pageNow, int pageSize) {
		return ticketDao.listForPage(pageNow, pageSize);
		
	}

}
