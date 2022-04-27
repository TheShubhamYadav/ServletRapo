package com.nt.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JdbcRowSetDemo {

	public static void main(String[] args) {
		
		try(JdbcRowSet jrowset=new OracleJDBCRowSet()){
			   //set jdbc properties
			   jrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			   jrowset.setUsername("system");
			   jrowset.setPassword("manager");
			   //set query
			   jrowset.setCommand("SELECT * FROM STUDENT");
			   //execute query
			   jrowset.execute();
			   //process the results
			   while(jrowset.next()) {
				   System.out.println(jrowset.getInt(1)+"  "+jrowset.getString(2)+"  "+jrowset.getString(3)+"  "+jrowset.getFloat(4));
			   }//while
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
