package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PstInsertTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			int count=0;
			if(sc!=null) {
				System.out.println("enter students count::");
				count=sc.nextInt();
			}
			
			//register  JDBC driver s/w (optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			 con=DriverManager.getConnection("jdbc:mysql:///ntaj915db", "root","root");
			 //create PreparedStatement object representing the pre-compiled SQL Query
			 if(con!=null) 
				 ps=con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
			 
			 //read multiple student details and set them to pre-compiled INSERT Query param values
			 for(int i=1;i<=count;++i) {
				 //read each student details
				 System.out.println("Enter "+i+"student details");
				 System.out.println("enter sno:");
				 int sno=sc.nextInt();
				 System.out.println("enter sname:");
				 String name=sc.next();
				 System.out.println("enter address:");
				 String addrs=sc.next();
				 System.out.println("enter avg:");
				 double avg=sc.nextDouble();
				 //set each student details to query param values
				  ps.setInt(1, sno);
				  ps.setString(2, name);
				  ps.setString(3, addrs);
				  ps.setDouble(4, avg);
				  //execute  the SQL query
				  int result=ps.executeUpdate();
				  //process the Results
				  if(result==0) 
					  System.out.println(i+" record not inserted");
				  else 
					  System.out.println(i+" record inserted");
			 }//for
		}//try
		catch(SQLException se) {
			se.printStackTrace();
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

	}//method
}//class

