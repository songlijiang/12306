package com.slj.Dao;

import java.util.List;

import com.slj.model.User;

public interface UserDao {
	
	public void add(User user);
	
	public Boolean checkByName(String name);

	public List<User> listUser();
	
	public User loadUser(int id);
	
	public boolean login(User user);
	public int getIdByname(User user);
	

}
