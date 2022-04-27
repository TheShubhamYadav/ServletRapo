//HikariConnPoolTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariDataSource;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class HikariConnPoolTest {

	public static void main(String[] args) {
	
		 HikariDataSource hkds=null;
		try {
		// DataSource obj pointing to empty jdbc con pool
           hkds=new HikariDataSource();
		if(hkds!=null) {
		//add jdbc properties to DataSource to create jdbc con objs in the jdbc con pool
		 hkds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		 hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		 hkds.setUsername("system");
		 hkds.setPassword("manager");
		 hkds.setMinimumIdle(10);
		 hkds.setMaximumPoolSize(1000);
		 hkds.setIdleTimeout(10000);  //if any con obj continuosly idle for 100000 ms  
		                                                            //then it will be removed from jdbc con pool
		// After giving all these properties  the jdbc con objs in jdbc con pool will be created
		}//if
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
				
		//get Pooled JDBC con obj
		try(Connection con=hkds.getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("SELECT *  FROM STUDENT")){
		//proess the ResultSet
		if(rs!=null) {
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
			}//while
		}//if
	}//try  //here con obj will closed and will be return jdbc con pool automatically
   catch(SQLException se) {
	  se.printStackTrace();
   }
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}//main
}//class
