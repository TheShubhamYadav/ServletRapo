package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TranferMoneyTxMgmtTest {

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
				 Statement st=con.createStatement();
				Scanner sc=new Scanner(System.in)){
			int srcNo=0,destNo=0;
			float amount=0.0f;
			if(sc!=null) {
				System.out.println("Enter soruce account number::");
				srcNo=sc.nextInt();
				System.out.println("Enter dest account number::");
				destNo=sc.nextInt();
				System.out.println("Enter the amount to transfer::");
				 amount=sc.nextFloat();
			}
			//begin Tx
			if(con!=null)
				con.setAutoCommit(false);
			//add queries to the batch
			if(st!=null) {
				  //with draw query
				st.addBatch("UPDATE JDBC_ACCOUNT SET BALANCE=BALANCE-"+amount+ "WHERE ACNO="+srcNo);
				  //deposite query
				st.addBatch("UPDATE JDBC_ACCOUNT SET BALANCE=BALANCE+"+amount+ "WHERE ACNO="+destNo);
				}
			//execute the Batch
			int result[]=null;
			if(st!=null) {
				result=st.executeBatch();
			}
			
			//perform Tx Mgmt
			if(result!=null) {
				boolean flag=false;
				for(int i=0;i<result.length;++i) {
					if(result[i]==0)
						flag=true;
				}//for
				if(flag) {
					con.rollback();
					System.out.println("Tx is rolled back (Money not transfered)");
				}
				else {
					con.commit();
					System.out.println("Tx is committed (Money is transfered)");
				}
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
