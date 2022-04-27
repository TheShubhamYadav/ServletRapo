//ConnPoolTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class ConnPoolTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
		// DataSource obj pointing to empty jdbc con pool
		OracleConnectionPoolDataSource  ds=new OracleConnectionPoolDataSource();
		if(ds!=null) {
		//add jdbc properties to DataSource to create jdbc con objs in the jdbc con pool
		ds.setDriverType("thin");
		ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUser("system");
		ds.setPassword("manager");
		ds.setMaxStatements(10);  //10 queries  at a time max
		// After giving all these properties  the jdbc con objs in jdbc con pool will be created
				
		//get Pooled JDBC con obj
		 con=ds.getConnection();
		}
		//create Statement objs
		if(con!=null)
		 st=con.createStatement();
		//create ResultSet obj
		if(st!=null) 
			rs=st.executeQuery("SELECT * FROM STUDENT");
		//proess the ResultSet
		if(rs!=null) {
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
			}//while
		}//if
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
			//close jdbc objs
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			//close jdbc objs
			try {
				if(con!=null)
					con.close();  // returns the jdbc con obj back to jdbc con pool
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally

	}//main
}//class
