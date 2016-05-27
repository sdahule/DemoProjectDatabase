package com.demoproject.webservice.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DatabaseConnection {
	
	static DataSource dataSource = null;
	static Connection con = null;
	public Statement dbstmt;
	public ResultSet dbRst;
	private Connection dbcon;
	
	public static Connection setConnection(){
		
		final Logger LOG = Logger.getLogger(DatabaseConnection.class);
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/demodb");
			con = dataSource.getConnection();
			LOG.debug("connection established.");
			} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				}
		return con;
	}
	
	
	public ResultSet getResultSet(Connection con, String query){
		
		dbcon = con;
		try{
			dbstmt = con.createStatement();
			dbRst = dbstmt.executeQuery(query);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return dbRst;
	}
	
	
}
