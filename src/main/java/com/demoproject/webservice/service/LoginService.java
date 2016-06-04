package com.demoproject.webservice.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.demoproject.webservice.dao.*;
import com.demoproject.webservice.model.User;


@Path("/login")
public class LoginService {

	final Logger LOG = Logger.getLogger(LoginService.class);
	
	private UserDao userDao = new UserDao();
	
	@GET
	@Path("user/{user_name}")
	@Produces(MediaType.APPLICATION_XML)
	public User getUserById(@PathParam("user_name") String username){
		return userDao.getUserByUsername(username);
		
	}
	
}
