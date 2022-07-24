//StudentRegistrationServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet( "/register") 
public class StudentRegistrationServlet extends HttpServlet {
	private static  final String   STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?)";
	@Resource(name="DsJndi")
	private DataSource ds;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String  name=req.getParameter("sname");
		String addrs=req.getParameter("sadd");
		float avg=Float.parseFloat(req.getParameter("avg"));
		//write jdbc code to insert the record to db table
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(STUDENT_INSERT_QUERY);		){
			   //set values to query params
			   ps.setString(1,name);
			   ps.setString(2, addrs);
			   ps.setFloat(3, avg);
			  //execute the Query
			   int result=ps.executeUpdate();
			   
			   if(result==0) {
				   pw.println("<h1 style='color:red;text-align:center'>Problem in Student registration </h1>");
			   }
			   else {
				   pw.println("<h1 style='color:red;text-align:center'> Student registered sucessfully </h1>");
			   }
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>DB Problem in student Registration </h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Unknown Problem in student Registration </h1>");
		}
		
		// add home hyperlink
		pw.println("<br> <a href='student_form.html'>home </a>");
		//close stream
		pw.close();
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           doGet(req,res);
	}//doPost(-,-)
	
	

}
