package com.slj.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.slj.dto.UserDTO;
import com.slj.model.User;
import com.slj.service.UserService;
@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<UserDTO>{
	
	private UserDTO userDTO = new UserDTO();
	private List<User> users;
	private User user ;  // ����load user
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	private UserService userService ;

	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(userDTO.getName());
		
		 if(!userService.CheckUserByName(userDTO.getName()) && userDTO.getPassword().equals(userDTO.getRepassword()))
		 {
			 User user = new User();
			 user.setName(userDTO.getName());
			 user.setPassword(userDTO.getPassword());
			 userService.Add(user);
			 System.out.println("login success!");
			 return Action.SUCCESS;
		 }
		 else
			 return "fail";
		
	}
	
	public String listUser() throws Exception{
		users = userService.list();
		return "listUser";
	}
	public String loadUser() throws Exception{
		user = (User)userService.loadUser(userDTO.getId());
		return "loadUser";
	}
	public String login() throws Exception{
		 User user = new User();
		 user.setName(userDTO.getName());
		 user.setPassword(userDTO.getPassword());
		System.out.println("from useraction.login()"+user.getName());
		if(userService.login(user))
		{
			ActionContext.getContext().getSession().put("user", user);
		return "loginsuccess";
		}
		return "loginfail";
	}

	public UserDTO getModel() {
		return userDTO;
	}
	

}
