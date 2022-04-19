//SelectTest6.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* SQL> select empno,ename,job,sal from emp where  empno=7491;*/

public class SelectTest6 {

	public static void main(String[] args) {
		//read inputs
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			sc=new Scanner(System.in);
			System.out.println("enter  employee no");
			int no=sc.nextInt(); //gives 1001
			
			//Load jdbc driver class (optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			//create Statement object
			if(con!=null)
			  st=con.createStatement();
			//prepare the SQL Query
			    // SELECT EMPNO,ENAME,JOB,SAL FROM EMP  WHERE  EMPNO=7499
			 String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP  WHERE  EMPNO="+no;
			  System.out.println(query);
			  
			  //send and execute the SQL Query
			  if(st!=null)
				  rs=st.executeQuery(query);
			  
			  //process the ResultSet object
			   if(rs!=null) {
				    if(rs.next()) {
				    	System.out.println("Record found");
				    	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				    }
				    else {
				    	System.out.println("record not found");
				    }
			   }//if
			   
			   System.out.println("con obj class name::"+con.getClass());
				 System.out.println("st obj class name::"+st.getClass());
				 System.out.println("rs obj class name ::"+rs.getClass());
			   
		}//try
		catch(ClassNotFoundException cnf) {  //known exception
			 cnf.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();   //known exception
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
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	}//main
}//class
