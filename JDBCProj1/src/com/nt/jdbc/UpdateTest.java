package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
	 Scanner sc=null;
	 Connection con=null;
	 Statement st=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			int no=0;
			String  newAddrs=null;
			float newAvg=0.0f;
			if(sc!=null) {
				System.out.println("Enter  student no to update his details");
				no=sc.nextInt(); //gives 1001
				System.out.println("Enter  new addrs for student ");
				newAddrs=sc.next(); //gives  delhi
				System.out.println("Enter  new avg for student ");
				newAvg=sc.nextFloat(); //gives  99.9
			}
			//convert input values as required for the SQL Query
			newAddrs="'"+newAddrs+"'"; //gives 'delhi'
			
			//register JDBC driver s/w  (optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj915db","root","root");
			//create Statement object
			if(con!=null)
				st=con.createStatement();
			
			//prepare SQL Query
			  // update  student set sadd='vizag', avg=99.99 where sno=1001;
			String query=" UPDATE  STUDENT SET SADD="+newAddrs+", AVG="+newAvg+" WHERE SNO="+no;
			 System.out.println(query);
			 //send and execute the SQL query
			 int count=0;
			 if(st!=null) {
				  count=st.executeUpdate(query);
			 }
			 //process the result
			 if(count==0) {
				  System.out.println("No record found for updation");
			 }
			 else {
				 System.out.println(count+" no.of records are updated");
			 }
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
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
			
		}//finally
		
	}//main
}//class
