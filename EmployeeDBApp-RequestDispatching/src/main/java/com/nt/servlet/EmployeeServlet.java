//EmployeeServlet.java  (Approach2)
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(value="/empurl",initParams = {@WebInitParam(name = "driver",value = "oracle.jdbc.driver.OracleDriver") ,
		                                                                            @WebInitParam(name = "url",value = "jdbc:oracle:thin:@localhost:1521:xe") ,
		                                                                            @WebInitParam(name = "dbuser",value = "system") ,
		                                                                            @WebInitParam(name = "dbpwd",value = "manager1") 
                                                                                   })
public class EmployeeServlet extends HttpServlet {
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //set response content type
		res.setContentType("text/html");
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//write jdbc code for DB interaction
		Connection con=null;
		PreparedStatement ps=null;
		 ResultSet  rs=null;
		try {
			//include  header 
			RequestDispatcher rd1=req.getRequestDispatcher("/headerurl");
			rd1.include(req, res);
	
		//read form data
		int  no=Integer.parseInt(req.getParameter("eno"));
	       pw.println("<b> hello  </b>");
		
			//get Access to ServletConfig  obj
			ServletConfig cg=getServletConfig();
			//read init param values
			String driver=cg.getInitParameter("driver");
			String url=cg.getInitParameter("url");
			String dbun=cg.getInitParameter("dbuser");
			String dbpwd=cg.getInitParameter("dbpwd");
			
			//load jdbc driver class
			Class.forName(driver);
			//establish the connection
			con=DriverManager.getConnection(url,dbun,dbpwd);
			//create Jdbc Statement obj
			 ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
			//set the query param value
			 ps.setInt(1, no);
			//execute the query
			  rs=ps.executeQuery();
			  //process the ResultSet
			 if(rs.next()) {
				pw.println("<div style='text-align:center' ><h1 style='color:blue'> Employee No:"+rs.getInt(1)+"</h1>");
				pw.println("<h1 style='color:blue'> Employee Name:"+rs.getString(2)+"</h1>");
				pw.println("<h1 style='color:blue'> Employee Desg:"+rs.getString(3)+"</h1>");
				pw.println("<h1 style='color:blue'> Employee salary:"+rs.getFloat(4)+"</h1>");
				pw.println("<h1 style='color:blue'> Employee deptno:"+rs.getInt(5)+"</h1>");
			 }
			 else {
				 pw.println("<h1 style='color:red'> Employee Not found</h1>");
			 }
			 
			 pw.println("<br><b> EmployeeServlet::  logical name or instance name ::"+cg.getServletName()+"</b>");
			 //home  hyperlink
			 pw.println("<a href='form.html'>home</a></div><br><br><br>");
			 
				//include  footer
			    pw.close();
				RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
				rd2.include(req, res);

			 
		}//try
		catch(Exception e) {
			e.printStackTrace();
		   ServletContext sc=getServletContext();
		    RequestDispatcher rd=sc.getNamedDispatcher("error");
			rd.forward(req, res);
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
		}
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            doGet(req,res);
	}//doPost(-,-)

}
