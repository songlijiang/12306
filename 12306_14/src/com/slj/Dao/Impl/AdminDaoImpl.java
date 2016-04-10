package com.slj.Dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.slj.Dao.AdminDao;
import com.slj.Dao.TicketDao;
import com.slj.model.Admin;
import com.slj.model.Ticket;

@Component("adminDaoImpl")
public class AdminDaoImpl implements AdminDao{

	private HibernateTemplate hibernateTemplate;
	private TicketDao ticketDao;
	
	public TicketDao getTicketDao() {
		return ticketDao;
	}
	@Resource(name="ticketDaoImpl")
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean CheckLogin(Admin admin) {
		List<Admin> admins = (List<Admin>)hibernateTemplate.find("from Admin a where a.name='"+admin.getName()+"'and a.password='"+admin.getPassword()+"'");
		System.out.println("admins.size="+admins.size());
		System.out.println("admin.name=="+admin.getName());
		System.out.println("admin.password=="+admin.getPassword());
			if(admins != null && admins.size() == 1)
			{
				return true;
			}
			return false;
	}
	public void addTicket(Ticket ticket) {
		hibernateTemplate.save(ticket);
		
	}
	

}
