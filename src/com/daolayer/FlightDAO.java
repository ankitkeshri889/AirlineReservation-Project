package com.daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.dbutilities.DBConnection;
import com.pojo.Flight;

public class FlightDAO {
	Connection conn= null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement ptmt = null;
	private Connection getDBConnection() throws SQLException 
	{
		conn=DBConnection.connect();
		return conn;
	}
	@SuppressWarnings("resource")
	public void fliinsert(Flight f1)
	{
		{
			try
			{
				Scanner s=new Scanner(System.in);
		        System.out.println("enter flight code");
			    String id=s.next();
				System.out.println("enter flight name");
				String name=s.next();
				System.out.println("enter source");
				String s_name=s.next();
				System.out.println("enter destination");
				String d_name=s.next();
				String query= "insert into flight(f_code,f_name,f_source,f_destination) values(?,?,?,?)";
				conn = getDBConnection();
				ptmt = conn.prepareStatement(query);
				ptmt.setString(1,id);
				ptmt.setString(2,name);
				ptmt.setString(3,s_name);
				ptmt.setString(4,d_name);
				ptmt.executeUpdate();
				System.out.println("Flight Added Successfully!");
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				try 
				{
					if (ptmt != null)
						ptmt.close();
					if (conn != null)
						conn.close();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			
	}
		}
	}
	public void flidisplay() 
	{
		try 
		{
			conn = getDBConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from flight");
			System.out.println("f_code\t  f_name\t  f_soure\t  f_destination");
			while (rs.next()) 
			{
				
			Flight e1=new Flight();
			e1.setF_code(rs.getString("f_code"));
			e1.setF_name(rs.getString("f_name"));
			e1.setF_source(rs.getString("f_source"));
			e1.setF_destination(rs.getString("f_destination"));
			System.out.println(e1.getF_code()+ "\t"+e1.getF_name()+ "\t"+e1.getF_source()+"\t"+e1.getF_destination());
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} 
			catch (Exception e)
			{
			}
		}
	}
	public void fliupdate() 
	{
		try
		{
			
			@SuppressWarnings("resource")
			Scanner s1=new Scanner(System.in);
			System.out.println("Enter flight code ::");
			String a=s1.next();
			System.out.println("Enter the source of arrival ::");
			String c=s1.next();
			System.out.println("Enter the destination of departure ::");
			String c1=s1.next();
			String query= "update flight set f_source=?,f_destination=? where f_code=?";
			conn = getDBConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, c);
			ptmt.setString(2, c1);
			ptmt.setString(3, a);
			int rows=ptmt.executeUpdate();
			if(rows>=1)
			{
				System.out.println("Record Exist!");
				System.out.println(rows + " Record Updated!");
			}
			else
			{
				System.out.println("Record Not Exist!");
				System.out.println(rows + "Record Updated!");
				
			}


			rs.close();
			conn.close();

}
		catch (Exception e)
		{
		}
		}
	public void flidelete() 
	{
		try
		{
			@SuppressWarnings("resource")
			Scanner s2=new Scanner(System.in);
			System.out.println("Enter Flight code which is not operational ::");
			String a=s2.next();
			String query=" delete from flight where f_code=? ";
			conn = getDBConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, a);
			
			int rows=ptmt.executeUpdate();
			if(rows>=1)
			{
				System.out.println("Record Exist!");
				System.out.println(rows + "Record deleted!");
			}
			else
			{
				System.out.println("Record Not Exist!");
				//System.out.println(rows + "Record not de!");
				
			}


			rs.close();
			conn.close();
			
		}
		catch (Exception e)
		{
		}
	}
}


