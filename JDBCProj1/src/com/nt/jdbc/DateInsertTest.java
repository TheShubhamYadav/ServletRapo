package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertTest {
  private static final String  INSERT_PERSON_DATES="INSERT INTO JDBC_PERSON_DATE VALUES(?,?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;

		try {
			//read inputs
			sc=new Scanner(System.in);
			String sdob=null,sdoj=null, sdom=null,pname=null;
			int pid=0;
			
			if(sc!=null) {
				System.out.println("Enter  Person id");
				 pid=sc.nextInt();
				 System.out.println("Enter  Person name");
				 pname=sc.next();
				System.out.println("Enter  DOB (dd-MM-yyyy)");
				sdob=sc.next();
				System.out.println("Enter  DOJ (MM-dd-yyyy)");
				sdoj=sc.next();
				System.out.println("Enter  DOM (yyyy-MM-dd)");
				sdom=sc.next();
			}//if
			//convert String date values to  java.sql.Date class objects
			  //for DOB
			      // to  java.util.Date class obj
			   SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			   java.util.Date udob=sdf.parse(sdob);
			   // to java.sql.Date class obj
			   long ms=udob.getTime();
			   java.sql.Date sqdob=new java.sql.Date(ms);
		  //for DOJ
		      // to  java.util.Date class obj
			   SimpleDateFormat sdf1=new SimpleDateFormat("MM-dd-yyyy");
			   java.util.Date udoj=sdf1.parse(sdoj);
			   // to java.sql.Date class obj
			   long ms1=udoj.getTime();
			   java.sql.Date sqdoj=new java.sql.Date(ms1);
		  //for DOM
				   // to java.sql.Date class obj
			     java.sql.Date sqdom=java.sql.Date.valueOf(sdom);
            //register  JDBC driver
			     Class.forName("oracle.jdbc.driver.OracleDriver");
			     //establish the connection
			      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			  //Create PreparedStatement object having pre-compiled SQL Query
			      if(con!=null)
			    	  ps=con.prepareStatement(INSERT_PERSON_DATES);
			     //set values to query params
			      if(ps!=null) {
			    	  ps.setInt(1, pid);
			    	  ps.setString(2, pname);
			    	  ps.setDate(3, sqdob);
			    	  ps.setDate(4, sqdoj);
			    	  ps.setDate(5,sqdom);
			      }
			      //execute the SQL query
			      int count=0;
			      if(ps!=null)
			    	  count=ps.executeUpdate();
			      //process the result
			      if(count==0)
			    	  System.out.println("Record not inserted");
			      else
			    	  System.out.println("Record inserted");
		}//try
		catch(ClassNotFoundException cnf) {  //known exception
			 cnf.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();   //known exception
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
