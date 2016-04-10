package com.slj.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.slj.dto.TicketDTO;
import com.slj.model.Admin;
import com.slj.model.Ticket;
import com.slj.service.AdminService;
@Component("adminAction")
public class AdminAction extends ActionSupport implements ModelDriven<TicketDTO>{
	private AdminService adminService;
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String password;
	private TicketDTO ticketDTO = new TicketDTO();
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		 System.out.println("from adminaction .setpassword="+this.password);
	}

	public AdminService getAdminService() {
		return adminService;
	}

	@Resource(name="adminServiceImpl")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public String execute() throws Exception {
		String state = null;
		Admin admin = new Admin();
		admin.setName(this.name);
		admin.setPassword(this.password);
		
		String flag =  adminService.CheckValidOfAdmin(admin);
		System.out.println(flag+"from adminaction and admindaoimpl");  // just for test
		if(flag.equals("success"))
		{
			ActionContext.getContext().getSession().put("admin", admin);
			ActionContext.getContext().getSession().put("adminflag", "success");
			state = "success";
			System.out.println(state + "from adminaction.execute ");  // just for test
			return "success";
		}
		state = "login";
		System.out.println(state+ "from adminaction.execute ");   // just for test
		 return "login";
	}
	public String addTicket()
	{
		System.out.println( "from adminaction.addticket ");   // just for test
		Ticket ticket = new Ticket();
		ticket.setName(ticketDTO.getTname());
		ticket.setEndstation(ticketDTO.getEndstation());
		ticket.setStartstation(ticketDTO.getStartstation());
		ticket.setStarttime(ticketDTO.getStarttime());
		ticket.setEndtime(ticketDTO.getEndtime());
		ticket.setStations(ticketDTO.getStations());
		ticket.setNum(ticketDTO.getNum());
		adminService.addTicket(ticket);
		return "success";
	}
	public String deleteTicketByAdmin()
	{
		int tid = (Integer)ActionContext.getContext().getSession().get("admindid");
		System.out.println("adminaction.deleteticketbyadmin"+tid);
		System.out.println("adminaction.deleteticketbyadmin"+tid);
		adminService.deleteTicketByAdmin(tid);
		return "success";
		
	}

	public TicketDTO getModel() {
		
		return ticketDTO;
	}

}
