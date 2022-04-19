//ExcelInsertTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcelInsertTest{
	  private static final String   INSERT_SHEET_QUERY="INSERT INTO Sheet1 Values(?,?,?,?)";
	public static void main(String args[]) {
		
		try(Connection con=DriverManager.getConnection("jdbc:Excel:///G:/Worskpaces/advjava/NTAJ915/College.xlsx");
				PreparedStatement ps=con.prepareStatement(INSERT_SHEET_QUERY);
				){
			 if(ps!=null) {
				 //set query param values
				 ps.setInt(1,1011);
				 ps.setString(2, "dtable");
				 ps.setFloat(3,9001.0f);
				 ps.setFloat(4, 91.0f);
				 //execut the query
				 int result=ps.executeUpdate();
				 //process the results
				 if(result==0)
					 System.out.println("record not inseerted");
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