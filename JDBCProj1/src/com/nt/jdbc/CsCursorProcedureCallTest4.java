//CsCursorProcedureCallTest4.java
package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;




/*CREATE OR REPLACE PROCEDURE P_GET_EMPS_BY_INITIAL_CHARS 
(
  INITIALCHARS IN VARCHAR2 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
  OPEN DETAILS FOR
    SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE ENAME LIKE INITIALCHARS;
END P_GET_EMPS_BY_INITIAL_CHARS;
*/

public class CsCursorProcedureCallTest4 {
  private static final String  CALL_PROCEDURE="{CALL P_GET_EMPS_BY_INITIAL_CHARS(?,?)}";
	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
				CallableStatement  cs=con.prepareCall(CALL_PROCEDURE);
				){
			//read input values
			String initialChars=null;
			if(sc!=null) {
				System.out.println("Enter  intiial chars of employee name::");
				initialChars=sc.next();
			}
			if(cs!=null) {
				//register  OUT parameters with JDBC types
				cs.registerOutParameter(2,OracleTypes.CURSOR);
				//set values to IN params
				cs.setString(1, initialChars+"%");
				//call PL/SQL procedure
				cs.execute();
				//gather result from OUT param
				 try(ResultSet rs=(ResultSet)cs.getObject(2)){
					 if(rs!=null) {
						 System.out.println("Employee detials whose name starts with "+initialChars);
						 boolean isRSEmpty=true;
						 while(rs.next()) {
							 isRSEmpty=false;
							 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getFloat(4));
						 }//while
						 if(isRSEmpty)
							 System.out.println("Records not found");
						 
					 }//if
				 }//try2
			}//if
			
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	

	}//main
}//class
