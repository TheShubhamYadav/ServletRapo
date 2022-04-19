//InsertTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest_mysql {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement  st=null;
		try {
			//read input values
			sc=new Scanner(System.in);
			int no=0;
			String name=null, addrs=null;
			float avg=0.0f;
			if(sc!=null) {
				System.out.println("Enter student number ::");
				no=sc.nextInt(); // gives 1001
				System.out.println("Enter student name ::");
				name=sc.next();  //gives  raja
				System.out.println("Eenter student address");
				addrs=sc.next();  //gives  hyd
				System.out.println("Enter  student avg::");
				avg=sc.nextFloat(); //gives 90.6
			}//if
			//convert input values  as required for the SQL Query
			  name="'"+name+"'"; //gives  'raja'
			  addrs="'"+addrs+"'"; //gives 'hyd'
			
			//register JDBC driver s/w  (optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj915db","root","root");
			//create Statement object
			if(con!=null)
				st=con.createStatement();
			//prepare SQL Query
			     //insert into student values(1001,'raja','hyd',90.6);
			String query="INSERT INTO STUDENT VALUES("+no+","+name+","+addrs+","+avg+")";
			  System.out.println(query);
			  
			  //send and execute the SQL Query in Db s/w
			  if(st!=null) {
				  int count=st.executeUpdate(query);
				  //rpcess the process
				  if(count==0)
					  System.out.println("Record not inserted");
				  else
					  System.out.println(" record inserted");
			  }//if
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
