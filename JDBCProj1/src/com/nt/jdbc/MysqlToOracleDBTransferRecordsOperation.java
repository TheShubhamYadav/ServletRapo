//MysqlToOracleDBTransferRecordsOperation.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MysqlToOracleDBTransferRecordsOperation {
   private static final String  ORACLE_STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(ORA_SNO_SEQ.NEXTVAL,?,?,?)";
   private static final String  MYSQL_GET_STUDENTS_QUERY="SELECT SNAME,SADD,AVG FROM STUDENT";
	public static void main(String[] args) {
		
		try {
			//register  jdbc drivers  (optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");  //for oracle
			Class.forName("com.mysql.cj.jdbc.Driver");  //for mysql
		}//try
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		try(  //establish the connections
				Connection oraCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				Connection mysqlCon=DriverManager.getConnection("jdbc:mysql:///ntaj915db","root","root");
				 //create Statement objs
				 Statement mysqlST=mysqlCon.createStatement();
				PreparedStatement oraPS=oraCon.prepareStatement(ORACLE_STUDENT_INSERT_QUERY);
				 //execute the  Query  (on student  db tgable of mysql)
				ResultSet rs=mysqlST.executeQuery(MYSQL_GET_STUDENTS_QUERY);
				){
			  
			  //process the ResultSet (mysql) and insert each record into  oracle DB table
			  if(rs!=null) {
				  while(rs.next()) {
					  //get each record from mysql db table through RS
					 String name=rs.getString(1);
					 String addrs=rs.getString(2);
					 float avg=rs.getFloat(3);
					 //set each recieved record values to  INSERT SQL Query of oracle
					 oraPS.setString(1, name);
					 oraPS.setString(2, addrs);
					 oraPS.setFloat(3, avg);
					 //execute the Query
					 oraPS.executeUpdate();
				  }//while
				  System.out.println("Records are transffered from mysql DB table to oracle db table");
			  }// if
		}//try  (all JDBC objs will be closed here automatically)
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("Problem in transfering records");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problem in transfering records");
		}
		
		
	}

}
