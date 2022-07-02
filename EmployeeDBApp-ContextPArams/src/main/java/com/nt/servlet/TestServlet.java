package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
               //get PrintWriter
		    PrintWriter pw=res.getWriter();
		    // set response content type
		     res.setContentType("text/html");
		     //get Access to ServletContext obj
		     ServletContext sc=getServletContext();
		     //read context param value
		     pw.println("<b> TestServlet:: dbpwd context param value ::"+sc.getInitParameter("dbpwd")+"</b>");
		     
		     //get Access to ServletConfig obj
		     ServletConfig cg=getServletConfig();
		   //read init param value
		     pw.println("<b> TestServlet:: dbpwd init param value ::"+cg.getInitParameter("dbpwd")+"</b>");
		     
		     
		     //close stream
		     pw.close();
		     
	}//doGet(-,-)

}//class
