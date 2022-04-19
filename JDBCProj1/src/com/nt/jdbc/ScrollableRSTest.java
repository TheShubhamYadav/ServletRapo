package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableRSTest {

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "manager");
				 Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				//Scrollable RS
				 ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");
				){
			  if(rs!=null) {
				  System.out.println("Records (top to bottom)");
				  while(rs.next()) {
					  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				  }
				  System.out.println("------------------------------");
				  rs.afterLast();
				  System.out.println("Records ( bottom to top)");
				  while(rs.previous()) {
					  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				  }
				  System.out.println("------------------------------");
				  rs.first();
				  System.out.println(rs.getRow()+"------ "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				  rs.last();
				  System.out.println(rs.getRow()+"------ "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				  rs.relative(-5);
				  System.out.println(rs.getRow()+"------ "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				  rs.relative(2);
				  System.out.println(rs.getRow()+"------ "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				  rs.absolute(6);
				  System.out.println(rs.getRow()+"------ "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
				  rs.absolute(-8);
				  System.out.println(rs.getRow()+"------ "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
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
