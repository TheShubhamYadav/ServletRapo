//LcTestServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	
	static {
		System.out.println("LcTestServlet: static block");
	}
	
	public LcTestServlet() {
		System.out.println("LcTestServlet:: 0-param constructor");
	}
	
		@Override
		public void init(ServletConfig cfg) throws ServletException {
			 System.out.println("LcTestServlet.init(-)");
			 System.out.println("driver class name ::"+cfg.getInitParameter("driverclass"));
			 System.out.println("db username ::"+cfg.getInitParameter("dbuser"));
			 System.out.println("db password::"+cfg.getInitParameter("dbpwd"));
		}
	
	
	
	@Override
	public  void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServlet.doGet(-,-)");
        //get PrintWriter 
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 // write  output to response object
		 pw.println("<h1>Date and Time :: "+new java.util.Date()+"</h1>");
		 
		 //close strea
		 pw.close();
		 
	}//service(-,-)
	
	
	@Override
	public void destroy() {
	  System.out.println("LcTestServlet:destroy()");
	}
	

}//class
