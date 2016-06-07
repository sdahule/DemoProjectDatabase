package com.demoproject.webservice.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;

public class HibernateUtil {
	
	public static SessionFactory sessionFactory = null;
	
	static{
		try{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			ex.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
