package com.slj.action;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.slj.model.Ticket;
import com.slj.model.User;
import com.slj.service.TicketService;

@Component("ticketAction")
public class TicketAction extends ActionSupport {
	public static int pageSize = 5;
	private TicketService ticketService;
	private List<Ticket> tickets;
	private String startStation;
	private String endStation;
	private int pageNow;
	private int pageAll;
	
	public int getPageAll() {
		return pageAll;
	}

	public void setPageAll(int pageAll) {
		this.pageAll = pageAll;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		System.out.println("public void setPageNow当前页码�"+pageNow);
		this.pageNow = pageNow;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public TicketService getTicketService() {
		return ticketService;
	}

	@Resource(name="ticketServiceImpl")
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	

	public List<Ticket> getTickets() {
		System.out.println("getTickets");
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String execute() throws Exception {           //listTicket
		 pageAll= (ticketService.listTicket().size()+pageSize-1)/pageSize;
		tickets = ticketService.listForPage(pageNow, pageSize);
		return "success";
	}
	
	public String buyTicketById()throws Exception {
		System.out.print("TicketAction.buyTicketById()");
		int id = (Integer)ActionContext.getContext().getSession().get("tid");
		User user = (User) ActionContext.getContext().getSession().get("user");
		ticketService.buyTicketById(user, id);
		return "success";
	}
	public String findTicketByOrderId() throws Exception {
	
		User user = (User)ActionContext.getContext().getSession().get("user");
		 tickets = ticketService.findTicketByOrderId(user);
		return "success";
	}
	public String  deleteTicketByTid() {
		
		int did = (Integer)ActionContext.getContext().getSession().get("did");
		User user = (User) ActionContext.getContext().getSession().get("user");
		ticketService.deleteTicketByTidFromUser(user, did);
		return "success";
	}
	public String searchTicket()
	{
		System.out.print("TicketAction.searchTicket().startStation= "+startStation);
		tickets = ticketService.searchTicket(startStation, endStation);
		return "success";
	}

}
