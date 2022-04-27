//BatchProcessingTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingTest {

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
				 Statement st=con.createStatement();	){
			
			if(st!=null) {
				//add queries to the batch
				st.addBatch("INSERT INTO STUDENT VALUES(121,'raja','vizag',56.77)");
				st.addBatch("UPDATE STUDENT SET AVG=AVG+100 WHERE SADD='vizag' ");
				st.addBatch("DELETE FROM STUDENT WHERE SNO>=1000 ");
				//execute the batch
				int result[]=st.executeBatch();
				//process the results
				int total=0;
				for(int i=0;i<result.length;++i)
					total=total+result[i];
				
				System.out.println("no.of records that are effected::"+total);
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
