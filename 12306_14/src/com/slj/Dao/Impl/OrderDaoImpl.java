package com.slj.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.slj.Dao.OrderDao;
import com.slj.model.Order;
import com.slj.model.Ticket;
@Component("orderDaoImpl")
public class OrderDaoImpl implements OrderDao{
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean addOrder(int orderid, int ticketid) {
		
		Order order = new Order();
		order.setOrderid(orderid);
		order.setTicketid(ticketid);
		order.setNum(1);
		
		List<Order> orders =  (List<Order>) hibernateTemplate.find("from Order o where o.orderid="+order.getOrderid()+"and o.ticketid="+order.getTicketid());
		if(orders == null || orders.size() == 0 )
		{
			System.out.println("TicketDaoImpl. buyTicketById."+order.getOrderid()+"is new order");
			hibernateTemplate.save(order);
			hibernateTemplate.flush();    

		}
		else
		{
			System.out.println("TicketDaoImpl. buyTicketById."+order.getOrderid()+"is old order");
			Order o = orders.get(0);
			o.setNum(o.getNum()+1);
			hibernateTemplate.update(o);
			hibernateTemplate.flush();    // 注意点，如果此处不flush则不能完成存储操作。
		}
		return true;
	}

	@Override
	public void deleteOrder(int orderid, int ticketid) {
		List<Order> orders = hibernateTemplate.find("from Order o where o.orderid="+orderid +"and o.ticketid="+ticketid);
		System.out.println("TicketDaoImpl.deleteOrder.orders.size="+orders.size());
		System.out.println("TicketDaoImpl.deleteOrder.orderid="+orderid);
		System.out.println("TicketDaoImpl.deleteOrder.ticketid="+ticketid);

		Order order = orders.get(0);
		List<Ticket> tickets = hibernateTemplate.find("from Ticket t where t.id="+ticketid);
		Ticket ticket = tickets.get(0);
		ticket.setNum(ticket.getNum()+order.getNum());
		hibernateTemplate.update(ticket);
		hibernateTemplate.flush();
		hibernateTemplate.delete(order);
		hibernateTemplate.flush();
	}
	@Override
	public List<Ticket> findTicketByOrderId(int orderid) {
		String queryString = "from Order o where o.orderid="+orderid;
		List<Ticket> tickets = new ArrayList<Ticket>();
		List<Order> orders =	hibernateTemplate.find(queryString);
		System.out.println("findTicketByOrderId.orders.size="+orders.size());
		for(int i=0;i<orders.size() ;i++)
		{
			int ticketid = orders.get(i).getTicketid();
			int numoforder = orders.get(i).getNum();
			List<Ticket> t=	hibernateTemplate.find("from Ticket t where t.id="+ticketid);
			Ticket ticket = t.get(0);
			ticket.setNum(numoforder);
			tickets.add(ticket);
		}
		System.out.println("findTicketByOrderId.tickets.size="+tickets.size());

		return tickets;
	}

}
