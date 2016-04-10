package com.slj.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.slj.Dao.UserDao;
import com.slj.model.Ticket;
import com.slj.model.User;
import com.slj.service.UserService;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService{

	UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource(name="userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void Add(User user) {
		userDao.add(user);
		
	}

	public Boolean CheckUserByName(String name) {
		return userDao.checkByName(name);
	}

	public List<User> list() {
		return userDao.listUser();
	}

	public User loadUser(int id) {
		
		return userDao.loadUser(id);
	}

	public boolean login(User user) {
		boolean flag =  userDao.login(user);
		
		return flag;
		
	}

	public int getIdByname(User user) {
		
		return userDao.getIdByname(user);
	}

	

}
