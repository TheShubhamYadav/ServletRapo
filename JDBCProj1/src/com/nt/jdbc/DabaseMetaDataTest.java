//DabaseMetaDataTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DabaseMetaDataTest {

	public static void main(String[] args) {
	
		try(//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
				Connection con=DriverManager.getConnection("jdbc:mysql:///NTAJ915DB","root", "root");
				){
			DatabaseMetaData dbmd=null;
			  if(con!=null) 
				   dbmd=con.getMetaData();
			  if(dbmd!=null) {
				  System.out.println("Db s/w name ::"+dbmd.getDatabaseProductName());
				  System.out.println("DB s/w version::"+dbmd.getDatabaseProductVersion());
				  System.out.println("DB s/w version::"+dbmd.getDatabaseMajorVersion()+"."+dbmd.getDriverMinorVersion());
				  System.out.println("JDBC driver version:"+dbmd.getDriverMajorVersion()+"."+dbmd.getDatabaseMinorVersion());
				  System.out.println("All SQL keywords ::"+dbmd.getSQLKeywords());
				  System.out.println("All Numeric functions::"+dbmd.getNumericFunctions());
				  System.out.println("All  system  functions ::"+dbmd.getSystemFunctions());
				  System.out.println(" max table name length::"+dbmd.getMaxTableNameLength());
				  System.out.println("max username  length ::"+dbmd.getMaxUserNameLength());
				  System.out.println("supports procedures ?"+dbmd.supportsStoredProcedures());
				  System.out.println(" max tables in select query ::"+dbmd.getMaxTablesInSelect());
				  System.out.println(" max row size ::"+dbmd.getMaxRowSize());
			  }//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
