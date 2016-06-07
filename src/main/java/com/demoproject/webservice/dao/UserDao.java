package com.demoproject.webservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;

import com.demoproject.webservice.model.User;
import com.demoproject.webservice.utility.HibernateUtil;

public class UserDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<User> getUserByUsername(){
		List<User> users = null;
		User user = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
		//	user = (User) session.createSQLQuery("select * from demodb.users where user_name = '"+username+"'").uniqueResult();
			
			Query query  = session.createQuery("FROM User");
			users  = query.list();
			
			/*for(Iterator iterator = users.iterator();iterator.hasNext();){
				user = (User) iterator.next();
				System.out.println("id :::"+ user.getId());
				System.out.println("username ::::"+ user.getUsername());
				System.out.println("password ::::"+ user.getPassword());
			}*/
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if(session != null){
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}	
		return  users;
	}
	
	
	
	public List<User> getTestm(){
		
		User usr1 = new User("0001", "swa", "dfsdfsd");
		User usr2 = new User("0002", "swfdfa", "dfsdfdfdfsd");
		
		List users = new ArrayList<>();
		users.add(usr1);
		users.add(usr2);
		return users;
		
	}
}
