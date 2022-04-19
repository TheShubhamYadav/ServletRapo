//TimeStamp_SurrogatekeyTestForOracle.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TimeStamp_SurrogatekeyTestForMySQL {
   private static final String  INSERT_CUSTOMER_QUERY="INSERT INTO JDBC_CUSTOMER(CNAME,CADDRS,BILLAMOUNT,DTOP) VALUES(?,?,?,?)";
	public static void main(String[] args) {
			
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//read input vlaues
			sc=new Scanner(System.in);
			String cname=null, caddrs=null;
			float billAmt=0.0f;
			if(sc!=null) {
				System.out.println("Enter customer name::");
				cname=sc.next();
				System.out.println("Enter customer address::");
				caddrs=sc.next();
				System.out.println("Enter  customer billAmount");
				billAmt=sc.nextFloat();
			}
			   //Load   JDBC driver class  (optional)
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   //establish the connection
			  con=DriverManager.getConnection("jdbc:mysql:///ntaj915db", "root","root");
			  //create PreparedStatement obj having pre-compiled SQL Query
			  if(con!=null)
				  ps=con.prepareStatement(INSERT_CUSTOMER_QUERY);
			  //set values to query params
			  if(ps!=null) {
				   ps.setString(1,cname);
				   ps.setString(2, caddrs);
				   ps.setFloat(3, billAmt);
				   ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			  }
			  //execute the pre-compiled SQL Query
			  int count=0;
			  if(ps!=null)
				  count=ps.executeUpdate();
			  //process the results
			  if(count==0)
				  System.out.println("Record not inserted");
			  else
				  System.out.println("Record  inserted");
		}//try
		catch(SQLException se) {  //for known exception
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) { //for known exception
			cnf.printStackTrace();
		}
		catch(Exception e) {  //for unknown exception
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(ps!=null) 
					ps.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				
			try {
				if(con!=null) 
					con.close();
				}//try
				catch(SQLException se) {
					se.printStackTrace();
				}
			
			try {
				if(sc!=null) 
					sc.close();
				}//try
				catch(Exception e) {
					e.printStackTrace();
				}
			}//finally
		}//main
		
	}//class
