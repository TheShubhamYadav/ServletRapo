//DabaseMetaDataTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class ResultSetMetaDataTest {

	public static void main(String[] args) {
	
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
				 Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");
				){
			   //create ResultSetMeta Data obj
			ResultSetMetaData rsmd=null;
			 if(rs!=null)
				 rsmd=rs.getMetaData();
			
			 if(rsmd!=null) {
				 // pring col names
				 int colCount=rsmd.getColumnCount();
				 for(int i=1;i<=colCount;++i) {
					System.out.print(rsmd.getColumnName(i)+" \t\t\t "); 
				 }
				 System.out.println();
				 // pring col  data types
				 for(int i=1;i<=colCount;++i) {
						System.out.print(rsmd.getColumnTypeName(i)+" \t\t "); 
					 }
				 System.out.println();
				 //print col values
			while(rs.next()) {	 //iterates through  records
				 for(int i=1;i<=rsmd.getColumnCount();++i) { //iterates through col values of the records
					 System.out.print(rs.getString(i)+"\t\t\t  ");
				 }
				 System.out.println();
			}//while
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
