package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String user=null,pwd=null;
			if(sc!=null) {
				System.out.println("enter username ::");
				 user=sc.nextLine(); //gives raja
				System.out.println("enter password ::");
				 pwd=sc.nextLine(); //gives rani
			}//if
			//convert input values as the required for the SQL Query
			  user="'"+user+"'"; //gives 'raja'
			  pwd="'"+pwd+"'"; //gives 'rani'
			
			//register  JDBC driver s/w (optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			 //create Staement object
			 if(con!=null)
				 st=con.createStatement();
			 //prepare SQL Query
			     //select count(*) from userinfo where username='raja' and password='rani';
			  String query="SELECT  COUNT(*) FROM USERINFO WHERE USERNAME="+user+"  AND PASSWORD="+pwd;
			  System.out.println(query);
			  //send and execute the SQL Query
			  if(st!=null) 
				  rs=st.executeQuery(query);
			  //process the ResultSet object
			  if(rs!=null) {
			      rs.next();
			       int count=rs.getInt(1);
			       
			       if(count==0)
			    	   System.out.println("Invalid Credentials");
			       else
			    	   System.out.println("Valid Credentials");
			  }//if
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
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(st!=null)
					st.close();
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
