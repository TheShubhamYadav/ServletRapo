package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class PSUpdateTest {
  private static final String UPDATE_STUDENT_BY_SNO="UPDATE  STUDENT SET SADD=?,AVG=? WHERE ?=?";  
  
	public static void main(String[] args) {
		
	 Scanner sc=null;
	 Connection con=null;
	 PreparedStatement ps=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			int no=0;
			String  newAddrs=null;
			float newAvg=0.0f;
			if(sc!=null) {
				System.out.println("Enter  student no to update his details");
				no=sc.nextInt(); //gives 1001
				System.out.println("Enter  new addrs for student ");
				newAddrs=sc.next(); //gives  delhi
				System.out.println("Enter  new avg for student ");
				newAvg=sc.nextFloat(); //gives  99.9
			}
			
			//register JDBC driver s/w  (optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj915db","root","root");
			//create Statement object
			if(con!=null)
				ps=con.prepareStatement(UPDATE_STUDENT_BY_SNO);
			
			//set pre-compiled SQL Query params  values
			if(ps!=null) {
				ps.setString(1, newAddrs);
				ps.setDouble(2, newAvg);
				ps.setString(3, "SNO");
				ps.setInt(4, no);
			}
			
			 //send and execute the SQL query
			 int count=0;
			 if(ps!=null) {
				  count=ps.executeUpdate();
			 }
			 //process the result
			 if(count==0) {
				  System.out.println("No record found for updation");
			 }
			 else {
				 System.out.println(count+" no.of records are updated");
			 }
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
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
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}//finally
		
	}//main
}//class
