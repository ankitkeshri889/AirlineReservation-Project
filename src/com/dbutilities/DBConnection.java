package com.dbutilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection connect()
	 {

	         Connection connection = null;
	         try 
	         {
	             Class.forName("oracle.jdbc.driver.OracleDriver");
	             connection = DriverManager.getConnection("jdbc:oracle:thin:127.0.0.1:1521/ORCL",
	             "system","Oracle123");
	         } 
	        catch (Exception e) 
	         {
	             System.out.println("Connection Failed! Check output console"+e);          
	         }
	         if (connection != null) 
	         {
	             System.out.println("Successfully connected to database....!!");
	             System.out.println();
	         } 
	         else 
	         {
	             System.out.println("Database Connection Failed ..!!");
	         }
	         return connection;
	     }
}
