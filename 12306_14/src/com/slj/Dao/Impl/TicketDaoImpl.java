package com.slj.Dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.slj.Dao.OrderDao;
import com.slj.Dao.TicketDao;
import com.slj.Dao.UserDao;
import com.slj.model.Ticket;
import com.slj.model.User;

@Component("ticketDaoImpl")
public class TicketDaoImpl implements TicketDao{

	private HibernateTemplate hibernateTemplate;
	private OrderDao orderDao;
	private UserDao userDao;
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public OrderDao getOrderDao() {
		return orderDao;
	}
	@Resource(name="orderDaoImpl")
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate; 
	}
	
	
	
	
	public List<Ticket> list() {
		
		return (List<Ticket> )hibernateTemplate.find("from Ticket t where t.num>"+0);
	}
	
	/*
	 * �Ѿ��޸�
	 * 
	 * (non-Javadoc)
	 * @see com.slj.Dao.TicketDao#buyTicketById(int, int)
	 */
	public void buyTicketById(int userid, int id) {               // �Ѿ��޸�
		orderDao.addOrder(userid, id);
		List<Ticket> tickets = hibernateTemplate.find("from Ticket t where t.id="+id);
		Ticket ticket = tickets.get(0);
		ticket.setNum(ticket.getNum()-1);
		hibernateTemplate.update(ticket);
		hibernateTemplate.flush();
	}
	
	/*
	 * 
	 *  �Ѿ��޸�
	 * (non-Javadoc)
	 * @see com.slj.Dao.TicketDao#findTicketByOrderId(int)
	 */
	public List<Ticket> findTicketByOrderId(int orderid) {
		
		return orderDao.findTicketByOrderId(orderid);
	}
	/*
	 *  �Ѿ��޸�
	 * (non-Javadoc)
	 * @see com.slj.Dao.TicketDao#resetOrder(com.slj.model.User, int)
	 */
	public void resetOrder(User user, int did) {
		
		
		/*Ticket t = this.deleteTicketByTid(did);
		t.setOrderid(0);
		hibernateTemplate.save(t);
		*/

		List<Ticket> tickets = (List<Ticket>)hibernateTemplate.find("from Ticket t where t.id="+did);
		Ticket ticket = tickets.get(0);
		ticket.setNum(ticket.getNum()+1);
		hibernateTemplate.update(ticket);
		hibernateTemplate.flush();    // ע��㣬���˴���flush������ɴ洢������
		
		int userid = userDao.getIdByname(user);
		orderDao.deleteOrder(userid, did);
		
		
	}
	
	
	public Ticket deleteTicketByTid(int tid) 
	{

		System.out.println("TicketDaoImpl.deleteTicketBytId="+tid);
		List<Ticket> tickets = (List<Ticket>)hibernateTemplate.find("from Ticket t where t.id="+tid);
		System.out.println("TicketDaoImpl. deleteTicketBytId.ticketS.SIZE="+tickets.size());
		Ticket ticket = tickets.get(0);
		System.out.println("TicketDaoImpl. deleteTicketBytId.ticket="+ticket.getName()+":���="+ticket.getStartstation());
		hibernateTemplate.delete(ticket);
		hibernateTemplate.flush();   // ע��㣬���˴���flush������ɴ洢������
		return ticket;
	}
	@Override
	public List<Ticket> searchTicket(String startStation, String endStation) {
		String query = "from Ticket t where t.stations like '%"+startStation+"%"+endStation+"%'"+"and t.num>"+0 ;
		System.out.println(query);
		List<Ticket> tickets = (List<Ticket>)hibernateTemplate.find(query);
		return tickets;
	}
	@Override
	public List<Ticket> listForPage(int pageNow,int pageSize) {
//		String query = " top "+pageSize+" * from Ticket t where t.id not in(select top "+pageSize*(pageNow-1)+" id from Ticket )and num>0 ";
//		System.out.println(query);
//		List<Ticket> tickets = (List<Ticket>)hibernateTemplate.find(query);
//		return tickets;
		String query = "from Ticket t where t.num > 0";
		Query q = sessionFactory.getCurrentSession().createQuery(query);
		q.setFirstResult(pageSize*(pageNow-1));
		q.setMaxResults(pageSize);
		List<Ticket> tickets = (List<Ticket>)q.list();
	    return tickets;

		
	}

}
