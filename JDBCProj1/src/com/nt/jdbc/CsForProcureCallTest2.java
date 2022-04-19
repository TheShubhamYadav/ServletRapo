//CsForProcureCallTest2.java
package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*CREATE OR REPLACE PROCEDURE P_GET_EMP_DETAILS_BY_ID 
(
  NO IN NUMBER 
, NAME OUT VARCHAR2 
, DESG OUT VARCHAR2 
, SALARY OUT VARCHAR2 
) AS 
BEGIN
  SELECT ENAME,JOB,SAL INTO NAME,DESG,SALARY FROM EMP WHERE EMPNO=NO;
END P_GET_EMP_DETAILS_BY_ID;*/


public class CsForProcureCallTest2 {
   private  static final String  CALL_PROCEUDRE_QUERY="{CALL P_GET_EMP_DETAILS_BY_ID(?,?,?,?)}";
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
				CallableStatement cs=con.prepareCall(CALL_PROCEUDRE_QUERY);
				 Scanner sc=new Scanner(System.in);
				                               ){
			//read inputs
			int no=0;
			 if(sc!=null) {
				 System.out.println("Enter  employee number::");
				 no=sc.nextInt();
			 }
			 if(cs!=null) {
				 //register  OUT params with JDBC data types
				 cs.registerOutParameter(2,Types.VARCHAR);
				 cs.registerOutParameter(3,Types.VARCHAR);
				 cs.registerOutParameter(4,Types.FLOAT);
				 //set values  to IN param
				 cs.setInt(1, no);
				 //call PL/SQL procedure
				 cs.execute();
				 //gather results from  OUT params of PL/SQL procedure
				 System.out.println(" Employee name ::"+cs.getString(2));
				 System.out.println(" Employee desg ::"+cs.getString(3));
				 System.out.println(" Employee salary ::"+cs.getFloat(4));
			 }//if
			
		}//try
		catch(SQLException se) {
			System.out.println("Employee not found");
			se.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main
}//class
