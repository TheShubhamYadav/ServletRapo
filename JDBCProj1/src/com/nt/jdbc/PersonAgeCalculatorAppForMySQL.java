//PersonAgeCalculatorAppForMySQL.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonAgeCalculatorAppForMySQL {
    private static final String   AGE_CALCULATOR_QUERY="SELECT DATEDIFF(NOW() , DOB)/365.25  FROM JDBC_PERSON_DATE WHERE PID=?";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			int pid=0;
			if(sc!=null) {
				System.out.println("Enter Person Id:");
				pid=sc.nextInt();
			}
			
			   //register  JDBC driver
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     //establish the connection
		      con=DriverManager.getConnection("jdbc:mysql:///ntaj915db", "root","root");
		      //create PreparedStatement obj
		      if(con!=null)
		    	  ps=con.prepareStatement(AGE_CALCULATOR_QUERY);
		      //set query param value
		      if(ps!=null)
		    	  ps.setInt(1, pid);
		      //execute the query
		      if(ps!=null)
		    	    rs=ps.executeQuery();
		      //process the ResultSet
		      if(rs.next()) {
		    	  System.out.println("Person age::"+rs.getFloat(1));
		      }
		      else {
		    	  System.out.println("record not found");
		      }
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
		

	}

}
