package com.daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.dbutilities.DBConnection;
import com.pojo.Payment;
import com.pojo.Traveller;

public class PassengerDAO {
	Connection conn= null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement ptmt = null;
	private Connection getDBConnection() throws SQLException 
	{
		conn=DBConnection.connect();
		return conn;
	}
	public void pasinsert(Traveller p1)
	{
		try
		{
			
			String query= "insert into traveller(pnr_no,p_name,phone,adress,email,gender,age,nationality) values(?,?,?,?,?,?,?,?)";
			@SuppressWarnings("resource")
			Scanner s=new Scanner(System.in);
	        System.out.println("enter PNR Number ::");
		    int pnr =s.nextInt();
			System.out.println("enter p_name :: ");
			String name=s.next();
			System.out.println("enter phone number :: ");
			long phone =s.nextLong();
			System.out.println("enter address :: ");
			String add =s.next();
			System.out.println("enter email :: ");
			String email =s.next();
			System.out.println("enter gender :: ");
			String gend =s.next();
			System.out.println("enter age :: ");
			int age =s.nextInt();
			System.out.println("enter nationality :: ");
			String nat =s.next();
			conn = getDBConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1,pnr);
			ptmt.setString(2,name);
			ptmt.setLong(3,phone);
			ptmt.setString(4,add);
			ptmt.setString(5,email);
			ptmt.setString(6,gend);
			ptmt.setInt(7,age);
			ptmt.setString(8,nat);
			
			ptmt.executeUpdate();
			System.out.println("Traveller Details Added Successfully!");
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
	public void pasdisplay() 
	{
		try 
		{
			@SuppressWarnings("resource")
			Scanner s9 = new Scanner(System.in);
			System.out.println();
			System.out.println("\n Enter the PNR number :: ");
			int pnr = s9.nextInt();
			String query  = "select *from traveller where pnr_no =?";
			conn = getDBConnection();
			PreparedStatement p = conn.prepareStatement(query);
			p.setInt(1, pnr);
			
			rs = p.executeQuery();
			
			System.out.println("Traveller details found ");
			System.out.println();
			System.out.println("pnr_no\tp_name\tphone\tadress\temail\tgender\tage\tnationality");
			System.out.println();
			while(rs.next())
				{
					int a1=rs.getInt("pnr_no");//column name
					String b1=rs.getString("p_name");
					long d1 = rs.getLong("phone");
					String d2 = rs.getString("adress");
					String c2=rs.getString("email");
					String c1=rs.getString("gender");
					int f1 = rs.getInt("age");
					String f2 =rs.getString("nationality");
					//3rd column position=>salary
					System.out.println(a1 + " "+b1 + " "+d1+" "+d2+" "+c2+" "+c1+" "+f1+" "+f2);
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
	public void pasupdate() 
	{
		try
		{
			
			@SuppressWarnings("resource")
			Scanner s1=new Scanner(System.in);
			System.out.println("Enter pnr_no ::");
			int a=s1.nextInt();
			System.out.println("Enter new phone number ::");
			long c=s1.nextLong();
			String query= "update traveller set phone= ? where pnr_no= ?";
			conn = getDBConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setLong(1, c);
			ptmt.setInt(2, a);
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

//			ptmt=conn.prepareStatement("select * from traveller ");
//			ResultSet rs=ptmt.executeQuery();
//			
//			System.out.println("pnr_no\tp_name\tphone\tadress\temail\tgender\tage\tnationality");
//			
//			while(rs.next())
//			{
//				int a1=rs.getInt("pnr_no");//column name
//				String b1=rs.getString("p_name");
//				long d1 = rs.getLong("phone");
//				String d2 = rs.getString("adress");
//				String c2=rs.getString("email");
//				String c1=rs.getString("gender");
//				int f1 = rs.getInt("age");
//				String f2 =rs.getString("nationality");
//				//3rd column position=>salary
//				System.out.println(a1 + " "+b1 + " "+d1+" "+d2+" "+c2+" "+c1+" "+f1+" "+f2);
//			}
			rs.close();
			conn.close();
			
		}
		catch (Exception e)
		{
		}
		}
	public void pasdelete() 
	{
		try
		{
			@SuppressWarnings("resource")
			Scanner s2=new Scanner(System.in);
			System.out.println("Enter PNR Number ::");
			int a=s2.nextInt();
			String query=" delete from traveller where pnr_no=? ";
			conn = getDBConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, a);
			
			int rows=ptmt.executeUpdate();
			if(rows>=1)
			{
				System.out.println("Record Exist!");
				System.out.println(rows + " Record deleted!");
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
