//InSensitiveRSTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatableRSTest {
  private static final String  GET_STUDS_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "manager");
				 PreparedStatement ps=con.prepareStatement(GET_STUDS_QUERY,   //query
						                                                                                          ResultSet.TYPE_SCROLL_SENSITIVE,  //RS type
						                                                                                          ResultSet.CONCUR_UPDATABLE); //RS mode
				//Scrollable RS
				 ResultSet rs=ps.executeQuery();
				){
			  if(rs!=null) {
				  System.out.println("Records (top to bottom)");
				  while(rs.next()) {
					  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				  }//while
				  
					/*System.out.println("INSERT OPERATION");
					//insert operation
					rs.moveToInsertRow();  //creates  empty record in RS
					rs.updateInt(1, 1235);
					rs.updateString(2, "rajesh");
					rs.updateString(3, "hyd");
					rs.updateFloat(4,90.0f);  //inserts the record
					rs.insertRow();*/

					/*  System.out.println("UPDATE Operation");
					  rs.absolute(3);
					  rs.updateString(3,"vizag");
					  rs.updateRow();*/
				  
				  System.out.println("DELETE Operation");
				   rs.absolute(3);
				   rs.deleteRow();
				   
				  
				 
				  
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
