package com.daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.dbutilities.DBConnection;
import com.pojo.Payment;

@SuppressWarnings("unused")
public class PaymentDAO {
	Connection conn= null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement ptmt = null;
	
	private Connection getDBConnection() throws SQLException 
	{
		conn=DBConnection.connect();
		return conn;
	}
	public void payinsert(Payment f1)
	{
		try
		{ 
			
			String query= "insert into payment(pay_id,pnr_no,price,pay_date,f_code) values(?,?,?,?,?)";
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the id ");
			int id=sc.nextInt();
			System.out.println("enter the pnr ");
			int pnr=sc.nextInt();
//			count++;
			System.out.println("enter price");  //string 
			int price=sc.nextInt();
			System.out.println("enter pay date");  //string 
			String date=sc.next();
			System.out.println("enter dob flight code");  //string 
			String code=sc.next();
			java.sql.Date sqdob = java.sql.Date.valueOf(date);
			
			conn = getDBConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1,id);
			ptmt.setInt(2,pnr);//POJO CLASS METHODS
			
			ptmt.setInt(3,price);
			ptmt.setDate(4,sqdob);
			ptmt.setString(5,code);
			ptmt.executeUpdate();
			System.out.println("Traveller ticket booked Successfully!");
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
	public void paydisplay() 
	{
		try 
		{
			conn = getDBConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from payment");
			System.out.println("pay_id\tpnr_no\tprice\tpay_date\tf_code");
			while (rs.next()) 
			{				
			Payment e1=new Payment();
			e1.setPay_id(rs.getInt("pay_id"));
			e1.setPnr_no(rs.getInt("pnr_no"));
			
			e1.setPrice(rs.getInt("price"));
			e1.setPay_date(rs.getDate("pay_date"));
			e1.setF_code(rs.getString("f_code"));
			System.out.println(e1.getPay_id()+" "+e1.getPnr_no()+" "+e1.getPrice()+" "+e1.getPay_date()+" "+e1.getF_code());
		
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
	
	public void bookingPas() throws Exception {
		Scanner scan =new Scanner(System.in);
		System.out.println("Traveller history details of booking ..!! ");
		System.out.println("\n Enter the PNR number :: ");
		
		
		int pnr = scan.nextInt();
		conn = getDBConnection();
		PreparedStatement p = conn.prepareStatement("select *from payment where pnr_no =?");
		p.setInt(1, pnr);
		
		rs = p.executeQuery();
		
		System.out.println("Traveller details found ");
		System.out.println();
		System.out.println("pay_id\tpnr_no\tprice\tpay_date\tf_code");
		System.out.println();
		while (rs.next()) 
		{				
		Payment e1=new Payment();
		e1.setPay_id(rs.getInt("pay_id"));
		e1.setPnr_no(rs.getInt("pnr_no"));
		
		e1.setPrice(rs.getInt("price"));
		e1.setPay_date(rs.getDate("pay_date"));
		e1.setF_code(rs.getString("f_code"));
		System.out.println(e1.getPay_id()+" "+e1.getPnr_no()+" "+e1.getPrice()+" "+e1.getPay_date()+" "+e1.getF_code());
	
		}
		
		
	}
	
	public void pasFlight() throws Exception {
		Scanner scan =new Scanner(System.in);
		System.out.println("List of traveller for a particular flight..!! ");
		System.out.println("\n Enter the Flight code :: ");
		String code = scan.next();
		conn = getDBConnection();
		PreparedStatement p = conn.prepareStatement("select pay_id , pnr_no from payment where f_code =?");
		p.setString(1, code);
		
		rs = p.executeQuery();
		
		System.out.println("Traveller details found ");
		System.out.println();
		System.out.println("pay_id\tpnr_no");
		System.out.println();
		while (rs.next()) 
		{				
		Payment e1=new Payment();
		e1.setPay_id(rs.getInt("pay_id"));
		e1.setPnr_no(rs.getInt("pnr_no"));
//		e1.setPrice(rs.getInt("price"));
//		e1.setPay_date(rs.getDate("pay_date"));
//		e1.setF_code(rs.getString("f_code"));
		System.out.println(e1.getPay_id()+" "+e1.getPnr_no());
	
		}
		
		
	}
	
	
}
