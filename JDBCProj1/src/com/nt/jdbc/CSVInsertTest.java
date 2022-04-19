// CSVInsertTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CSVInsertTest {

	public static void main(String[] args) {
		
		
		try(Connection con=DriverManager.getConnection("jdbc:Text:///E:/JDBC");
				PreparedStatement ps=con.prepareStatement("INSERT INTO file1.csv VALUES(?,?,?,?)");
				){
			if(ps!=null) {
			//set vlaues to query params
			  ps.setInt(1, 2001);
			  ps.setString(2, "coffee table");
			  ps.setFloat(3,80000.0f);
			  ps.setFloat(4,99.0f);
			  //execute the Query
			  int result=ps.executeUpdate();
			  //process the result
			  if(result==0)
				  System.out.println("Record not inserted");
			  else
				  System.out.println("record inserted");
			}
		
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
