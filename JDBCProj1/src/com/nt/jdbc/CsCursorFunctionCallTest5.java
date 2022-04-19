//CsCursorFunctionCallTest5.java
package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

/*CREATE OR REPLACE FUNCTION FX_GET_STUD_DETAILS_BY_NO 
(
  NO IN NUMBER 
, NAME OUT VARCHAR2 
, ADDRS OUT VARCHAR2 
) RETURN FLOAT AS 
   aggregation float;
BEGIN
 
   SELECT SNAME,SADD,AVG INTO NAME,ADDRS, aggregation FROM STUDENT WHERE SNO=NO;
 
 RETURN aggregation;
 
END FX_GET_STUD_DETAILS_BY_NO;
*/
public class CsCursorFunctionCallTest5 {
  private static final String  CALL_FUNCTION="{?=call FX_GET_STUD_DETAILS_BY_NO  (?,?,?)}";
	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
				CallableStatement  cs=con.prepareCall(CALL_FUNCTION);
				){
			//read input values
			int no=0;
			if(sc!=null) {
				System.out.println("Enter  Student number::");
                no=sc.nextInt();				
			}
			if(cs!=null) {
				//register  OUT,RETURN parameters with JDBC types
				cs.registerOutParameter(1,OracleTypes.FLOAT); //return param
				cs.registerOutParameter(3, OracleTypes.VARCHAR);  //out param
				cs.registerOutParameter(4, OracleTypes.VARCHAR); //out param
				//set values to IN params
				cs.setInt(2, no);
				//call PL/SQL procedure
				cs.execute();
				//gather result from OUT params,RETURN PARAMS
				System.out.println(" Student name::"+cs.getString(3));  //out param
				System.out.println("Student addrs ::"+cs.getString(4));  //out param
				System.out.println("Student avg::"+cs.getFloat(1));  //return param
			}//if
		}//try
		catch(SQLException se) {
			System.out.println("Record not found");
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	

	}//main
}//class
