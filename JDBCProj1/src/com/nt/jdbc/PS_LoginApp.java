package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PS_LoginApp {
  private static final  String   AUTH_QUERY="SELECT COUNT(*) FROM USERINFO WHERE USERNAME=? AND PASSWORD=?";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
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
			
			//register  JDBC driver s/w (optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			 //create PreparedStaement object having pre-compiled SQL Query
			 if(con!=null)
				 ps=con.prepareStatement(AUTH_QUERY);
			 //set param vlaues to the pre-compiled SQL Query
			 if(ps!=null) {
				 ps.setString(1, user);
				 ps.setString(2,pwd);
			 }
			  //send and execute the SQL Query
			  if(ps!=null) 
				  rs=ps.executeQuery();
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
