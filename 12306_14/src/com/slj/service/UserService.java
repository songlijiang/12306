package com.slj.service;

import java.util.List;

import com.slj.model.Ticket;
import com.slj.model.User;

public interface UserService  {
	
	
	public Boolean CheckUserByName(String name);
	public void Add(User user);
	public List<User> list();
	public User loadUser(int id);
	public boolean login(User user);
	public int getIdByname(User user);
	

}
