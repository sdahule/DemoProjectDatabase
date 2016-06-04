package com.demoproject.webservice.dao;

import org.hibernate.*;

import com.demoproject.webservice.model.User;
import com.demoproject.webservice.utility.HibernateUtil;

public class UserDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public User getUserByUsername(String username){
		User user = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			user = (User) session.createSQLQuery("select * from demodb.users where user_name = '"+username+"'").uniqueResult();
				
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
		
		
		return user;
	}
	
}
