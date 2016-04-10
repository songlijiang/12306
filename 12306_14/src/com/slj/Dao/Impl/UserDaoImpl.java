package com.slj.Dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.slj.Dao.UserDao;
import com.slj.model.User;

@Component(value="userDaoImpl")
public class UserDaoImpl implements UserDao {

	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void add(User user) {
		
		this.hibernateTemplate.save(user);
		
	}
	public Boolean checkByName(String name) {
		String queryString = "from User u where u.name = '"+name+"'";
		List<User> list = hibernateTemplate.find(queryString);
		int length = list.size();
		if(length <=0)
			return false;
		return true;
		
	}
	public List<User> listUser() {
		return (List<User>)hibernateTemplate.find("from User");
	}
	public User loadUser(int id) {
		
		//User  u = (User)hibernateTemplate.load(User.class, id);
		List<User> list = (List<User>)hibernateTemplate.find("from User u where u.id='"+id+"'");
		User u =null;
		if(list.size()>=1)
			{
			u= list.get(0);
			System.out.println(u.getName());
			}			
		
		return u;
		
	}
	public boolean login(User user) {
		System.out.println("userDaoImpl.login"+user);
		String queryString ="from User u where u.name='"+user.getName()+"'and u.password='"+user.getPassword()+"'";
		System.out.println(queryString);
		List<User> list = (List<User>)hibernateTemplate.find(queryString);
		System.out.println("login����Ŀ"+list.size());
		if(list.size() == 0 || list == null)
		{
		return false;
		}
		return true;
	}
	public int getIdByname(User user) {
		System.out.print("userDaoImpl.getIdByNAME");
		List<User> users = (List<User>)hibernateTemplate.find("from User u where u.name='"+user.getName()+"'");
		User u= users.get(0);
		
		return u.getId();
	}

}
