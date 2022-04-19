package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class DateValuesRetrieveTestForMySQL {
   private static final String  GET_DATE_VALUES="SELECT * FROM JDBC_PERSON_DATE";
	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//Load jdbc driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj915db", "root", "root");
			//create PreparedStatement object
			if(con!=null)
				ps=con.prepareStatement(GET_DATE_VALUES);
			//execute the query
			if(ps!=null)
				rs=ps.executeQuery();
			//process the ResultSet
			if(rs!=null) {
				while(rs.next()) {
					
					//read date values as java.sql.Date class objs
					java.sql.Date sqdob=rs.getDate(3);
					java.sql.Date sqdoj=rs.getDate(4);
					java.sql.Date sqdom=rs.getDate(5);
					//convert  java.sql.Date class objs to java.util.Date class objs
					java.util.Date udob=sqdob;
					java.util.Date udoj=sqdoj;
					java.util.Date udom=sqdom;
					//convert  java.util.Date class objs to String date values
					SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
					String sdob=sdf.format(udob);
					String sdoj=sdf.format(udoj);
					String sdom=sdf.format(udom);
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+sdob+"    "+sdoj+"    "+sdom);
				}//while
			}//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(ps!=null)
					ps.close();
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
			
		}//finally
		

	}//main
}//class
