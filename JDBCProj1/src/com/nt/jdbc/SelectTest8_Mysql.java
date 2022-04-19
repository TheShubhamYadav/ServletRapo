//SelectTest8_Mysql.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest8_Mysql {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
		 //Load jdbc driver class (optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			//con=DriverManager.getConnection("jdbc:mysql:///ntaj915db", "root", "root");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj915db", "root", "root");
			//create STatement object
			 if(con!=null)
				 st=con.createStatement();
			 //prepare the SQL query
			 String qyery="SELECT * FROM STUDENT";
			 
			 //execute the Query
			 if(st!=null)
				 rs=st.executeQuery(qyery);
			 
			 //process the ResultSet obj
			 
			 if(rs!=null) {
				 boolean isEmptied=true;
				 while(rs.next()) {
					  isEmptied=false;
					 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				 }//while
				 if(isEmptied) {
					 System.out.println("records not found");
				 }//if
				 else {
					 System.out.println("records  found and displayed");
				 }//else
			 }//if
			 System.out.println("con obj class name::"+con.getClass());
			 System.out.println("st obj class name::"+st.getClass());
			 System.out.println("rs obj class name ::"+rs.getClass());
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
		
		}//finally

	}//main
}//class
