//SelectTest5.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SQL> select * from student where avg=(select max(avg) from student);  //sub query concept
public class SelectTest5 {
	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//register JDBC driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			//create Statement object
			if(con!=null)
			   st=con.createStatement();
			//prepare SQL Query
			String query=" SELECT * FROM STUDENT WHERE AVG=(SELECT MAX(avg) FROM STUDENT)";
			System.out.println(query);
			//send and execute SQL Query
			if(st!=null)
				rs=st.executeQuery(query);
			//process the ResultSEt obj
			if(rs!=null) {
				boolean isRSEmpty=true;
				while(rs.next()) {
					   isRSEmpty=false;
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				}
				 if(isRSEmpty)
					  System.out.println("No records found");
				 else
					 System.out.println(" records found and displayed");
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
		 }//finally
			
	}//main
}//class
