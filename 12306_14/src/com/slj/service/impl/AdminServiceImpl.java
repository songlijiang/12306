package com.slj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.slj.Dao.AdminDao;
import com.slj.Dao.TicketDao;
import com.slj.model.Admin;
import com.slj.model.Ticket;
import com.slj.service.AdminService;

@Component("adminServiceImpl")
public class AdminServiceImpl implements AdminService{

	private AdminDao adminDao;
	private TicketDao ticketDao;
	public TicketDao getTicketDao() {
		return ticketDao;
	}
	@Resource(name="ticketDaoImpl")
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	public AdminDao getAdminDao() {
		return adminDao;
	}
	@Resource(name="adminDaoImpl")
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	
	public String CheckValidOfAdmin(Admin admin) {
		
		if( adminDao.CheckLogin(admin))
			return "success";
		return "login";
	}
	public void addTicket(Ticket ticket) {
		adminDao.addTicket(ticket);
		
	}
	public void deleteTicketByAdmin(int tid) {
		ticketDao.deleteTicketByTid(tid);
		
	}

}
