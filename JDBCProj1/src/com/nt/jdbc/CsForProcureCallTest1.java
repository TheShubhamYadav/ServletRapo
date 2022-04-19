//CsForProcureCallTest1.java
package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsForProcureCallTest1 {
  private static final String CALL_PROCEDURE="{ call first_pro(?,?)}";
	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
				 CallableStatement cs=con.prepareCall(CALL_PROCEDURE);
				){
			
			//read input vlaues
			int no=0;
			if(sc!=null) {
				System.out.println("Etner number::");
				no=sc.nextInt();
			}//if
			
			if(cs!=null) {
			//register output params jdbc types
				 cs.registerOutParameter(2, Types.INTEGER);
			//set value to IN param
				 cs.setInt(1, no);
				//call PL/SQL procedure
				 cs.execute();
				 //gather results from  OUT param
				 int result=cs.getInt(2);
				 System.out.println("Square value ::"+result);
			}//if
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}//catch

	}//main
}//class
