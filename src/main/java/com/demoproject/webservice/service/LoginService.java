package com.demoproject.webservice.service;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.demoproject.webservice.DemoProjectDatabase.Users;
import com.demoproject.webservice.dao.*;
import com.demoproject.webservice.model.User;

import javassist.bytecode.Descriptor.Iterator;


@Path("/login")
public class LoginService {

	final Logger LOG = Logger.getLogger(LoginService.class);
	
	public UserDao userDao = new UserDao();
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public  List<User> getAllUers(){
		return userDao.getTestm();
		
	}
	
}
