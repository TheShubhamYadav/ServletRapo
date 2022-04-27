//WebRowSetDemo.java
package com.nt.jdbc;

import java.io.FileWriter;
import java.io.Writer;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSetDemo {

	public static void main(String[] args) {
		
		try(WebRowSet wrowset=new OracleWebRowSet()){
			   //set jdbc properties
			   wrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			   wrowset.setUsername("system");
			   wrowset.setPassword("manager");
			   //set query
			   wrowset.setCommand("SELECT * FROM STUDENT");
			   //execute query
			   wrowset.execute();
			   //process the results
			   while(wrowset.next()) {
				   System.out.println(wrowset.getInt(1)+"  "+wrowset.getString(2)+"  "+wrowset.getString(3)+"  "+wrowset.getFloat(4));
			   }//while
			   System.out.println("---------------------");
			   wrowset.writeXml(System.out);
			   System.out.println("------------------------");
			   Writer writer=new FileWriter("student.xml");
			   wrowset.writeXml(writer);
			   writer.flush(); writer.close();
			   
			   
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
