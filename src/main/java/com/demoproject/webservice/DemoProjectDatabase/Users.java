package com.demoproject.webservice.DemoProjectDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.*;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.demoproject.webservice.utility.DatabaseConnection;

@Path("/users")
public class Users {
	final Logger LOG = Logger.getLogger(Users.class);
	Connection con = null;
	ResultSet rslt = null;
	DatabaseConnection dbcon = null;
	
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
	@Path("/{user_name}")
	public String getLogin(@PathParam("user_name") String username){
		String password = null;
		String user_query ="select * from demodb.users where users.user_name='"+username+"';"; 
		LOG.debug("Login query===="+user_query);
		dbcon = new DatabaseConnection();
		con =DatabaseConnection.setConnection();
		rslt = dbcon.getResultSet(con, user_query);
		
		try {
			while(rslt.next()){
				
			password = rslt.getString("user_pass");
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
		
		
	}
}
