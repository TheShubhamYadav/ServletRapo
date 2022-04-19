//SelectTest7.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SQL> select count(*) from  emp;


public class SelectTest7 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			//create Statement obj
			if(con!=null)
			  st=con.createStatement();
			//prepare the SQL query
			String query="SELECT COUNT(*) FROM EMP";
			System.out.println(query);
			//send and execute the Query
			if(st!=null)
				rs=st.executeQuery(query);
			//process the ResultSet obj
			   if(rs!=null) {
				   rs.next();
				   //int count=rs.getInt(1);
				   int count=rs.getInt("count(*)");
				   System.out.println("emp db table records count is ::"+count);
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
			
		}
	
	}

}
