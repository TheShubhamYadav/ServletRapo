//TimeStamp_SurrogatekeyTestForMySQLUsingTWR.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TimeStamp_SurrogatekeyTestForMySQLUsingTWR {
   private static final String  INSERT_CUSTOMER_QUERY="INSERT INTO JDBC_CUSTOMER(CNAME,CADDRS,BILLAMOUNT,DTOP) VALUES(?,?,?,?)";
	public static void main(String[] args) {
			
		try(Scanner sc=new Scanner(System.in);
               Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj915db", "root","root");
				  PreparedStatement ps=con.prepareStatement(INSERT_CUSTOMER_QUERY)	){  //try with resource
			
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
		}//try   (sc,con, ps will be closed automatically here)
		catch(SQLException se) {  //for known exception
			se.printStackTrace();
		}
		catch(Exception e) {  //for unknown exception
			e.printStackTrace();
		}
	}//main		
	}//class
