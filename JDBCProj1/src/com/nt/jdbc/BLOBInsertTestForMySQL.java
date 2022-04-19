//BLOBInsertTestForMySQL.java
package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BLOBInsertTestForMySQL {
  private static final String  INSERT_ACTOR_QUERY="INSERT INTO JDBC_ACTOR_TAB(ACTORNAME,ACTORADDRS,PHOTO) VALUES(?,?,?)";
	public static void main(String[] args) {
	
		 try(Scanner sc=new Scanner(System.in);
				 Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj915db","root","root");
				 PreparedStatement ps=con.prepareStatement(INSERT_ACTOR_QUERY);
				 ){
			 
			 //read input values
			 String actorName=null,actorAddrs=null,photoLocation=null;
			 if(sc!=null) {
				 System.out.println("Enter  actor name::");
				 actorName=sc.next();
				 System.out.println("Enter  actor address::");
				 actorAddrs=sc.next();
				 System.out.println("Enter Photo Location::");
				 photoLocation=sc.next().replace('?',' ').trim();
			 }
			 //create Stream pointing to Photo file
			 InputStream is=new FileInputStream(photoLocation);
			 
			 //set query param vlaues
			 if(ps!=null) {
				 ps.setString(1,actorName);
				 ps.setString(2,actorAddrs);
				 ps.setBinaryStream(3,is);
			 }
			 //execute the Query
			 int count=0;
			 if(ps!=null) 
				 count=ps.executeUpdate();
			 //process the Result
			 if(count==0)
			     System.out.println("Record not inserted");
			 else
				 System.out.println("Record  inserted");
		 }//try
		 catch(SQLException se) {
			 se.printStackTrace();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }

	}//main
}//class
