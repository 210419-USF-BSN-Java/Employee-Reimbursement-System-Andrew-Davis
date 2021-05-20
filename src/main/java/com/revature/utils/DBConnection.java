package com.revature.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static Connection connection = null;
	
	private DBConnection() {
		// Now this class cannot be instantiated
	}
	
	///*
	public static Connection getConnectionFromFile() throws SQLException, IOException
	{
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("connection.properties"));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
	//*/
	/*
	 public static Connection getConnection() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
    	String username = "postgres";
    	String password = "password";
        try {
        	//Class.forName("org.postgresql.Driver");
        	// This will check to make sure that the connection is not already open or created ...
        	// ... even though it is in a static block, you will need to check for the isClosed() too
        	if(connection == null || connection.isClosed()) {
        		connection = DriverManager.getConnection(url, username, password);
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        	System.err.println(e.getClass().getName() + ": " + e.getMessage());
        	System.exit(0);
        }
        System.out.println("Opened database successfully");
        
        return connection;
	}
	*/
}
