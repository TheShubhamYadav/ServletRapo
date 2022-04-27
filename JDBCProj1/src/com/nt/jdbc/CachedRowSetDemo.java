//CachedRowSetDemo.java
package com.nt.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CachedRowSetDemo {

	public static void main(String[] args) {
		
		try(CachedRowSet crowset=new OracleCachedRowSet()){
			   //set jdbc properties
			   crowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			   crowset.setUsername("system");
			   crowset.setPassword("manager");
			   //set query
			   crowset.setCommand("SELECT * FROM STUDENT");
			   //execute query
			   crowset.execute();
			   //process the results
			   while(crowset.next()) {
				   System.out.println(crowset.getInt(1)+"  "+crowset.getString(2)+"  "+crowset.getString(3)+"  "+crowset.getFloat(4));
			   }//while
			   
			   System.out.println("stop the db s/w during  the sleep period of the application");
			   Thread.sleep(60000);
			   crowset.absolute(3);
			   crowset.updateString(3, "hyd456");
			   crowset.updateRow();
			   System.out.println("start the db s/w during  the sleep period of the application");
			   Thread.sleep(90000);
			   crowset.acceptChanges();
			 //process the results
			   while(crowset.next()) {
				   System.out.println(crowset.getInt(1)+"  "+crowset.getString(2)+"  "+crowset.getString(3)+"  "+crowset.getFloat(4));
			   }//while
			   
			   
			   
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
