//DeleteTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			float startAvg=0.0f, endAvg=0.0f;
			if(sc!=null) {
				System.out.println("Enter start avg range::");
				startAvg=sc.nextFloat();
				System.out.println("Enter end avg range::");
				endAvg=sc.nextFloat();
			}
			
			//Load jdbc driver class (optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			//create Statement object
			if(con!=null)
			  st=con.createStatement();
			//prepare the SQL Query
			     // DELETE FROM STUDENT WHERE AVG>=67.88 AND AVG<=90.77;
			      String query="DELETE FROM STUDENT WHERE AVG>="+startAvg+" AND AVG<="+endAvg;
			      System.out.println(query);
			  //send execute the non-select SQL query
			      int count=0;
			      if(st!=null)
			    	  count=st.executeUpdate(query);
			      //process the Result
			      if(count==0)
			    	  System.out.println("No records found for deletion");
			      else
			    	  System.out.println(count+" records found and deleted");
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
