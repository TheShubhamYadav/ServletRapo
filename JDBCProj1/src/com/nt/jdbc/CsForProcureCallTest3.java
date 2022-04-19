//CsForProcureCallTest3.java
package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


/*CREATE OR REPLACE PROCEDURE P_AUTHENTICATION 
(
  UNAME IN VARCHAR2 
, PWD IN VARCHAR2 
, RESULT OUT VARCHAR2 
) AS 
   CNT NUMBER(2);
BEGIN
    SELECT COUNT(*) INTO CNT FROM USERINFO WHERE USERNAME=UNAME AND PASSWORD=PWD;
    IF(CNT<>0)THEN
       RESULT:='VALID CREDENTIALS';
    ELSE
       RESULT:='INVALID CREDENTIALS';
    END IF;   
    
END P_AUTHENTICATION;
*/

public class CsForProcureCallTest3 {
	 private static final String CALL_PROCEUDRE_QUERY="{CALL P_AUTHENTICATION(?,?,?)}";
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
				CallableStatement cs=con.prepareCall(CALL_PROCEUDRE_QUERY);
				 Scanner sc=new Scanner(System.in);
				                               ){
			//read inputs
			String user=null,pass=null;
			if(sc!=null) {
				System.out.println("Enter username ::");
				user=sc.next();
				System.out.println("Enter password ::");
				pass=sc.next();
			}
			if(cs!=null) {
				//register OUT params with JDBC types
				cs.registerOutParameter(3,Types.VARCHAR);
				//set values to IN param
				cs.setString(1,user);
				cs.setString(2, pass);
				//call PL/SQL procedure
				cs.execute();
				//gather result from OUT params
				String  result=cs.getString(3);
				System.out.println("Result :::"+result);
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
