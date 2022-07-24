package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
		     pw.println("<br> server info :: </b>"+sc.getServerInfo());
		     pw.println("<br> servlet api version ::"+sc.getMajorVersion()+" ."+sc.getMinorVersion());
		     pw.println("<br> absolute path of web application::"+sc.getRealPath("/"));
		     pw.println("<br> absolute path of form.html::"+sc.getRealPath("/form.html"));
		     pw.println("<br>  web application name /context path::"+sc.getContextPath());
		     pw.println("<br> MIME type of form.html file  ::"+sc.getMimeType("form.html"));
		     pw.println("<br> servlet comp names :: ");
		      Enumeration<String> e=sc.getServletNames();
		      while(e.hasMoreElements()) {
		    	  pw.println(e.nextElement()+",");
		      }
		     
		      pw.println("<br><br> ServletContext obj class name::"+sc.getClass()+"</b>");
		      
		     //read context param value
		     pw.println("<br><b> TestServlet:: dbuser context param value ::"+sc.getInitParameter("dbuser")+"</b>");
		     
		     
		     
		     //get Access to ServletConfig obj
		     ServletConfig cg=getServletConfig();
		   //read init param value
		     pw.println("<b> TestServlet:: dbpwd init param value ::"+cg.getInitParameter("dbpwd")+"</b>");
		     
		     
		     //close stream
		     pw.close();
		     
	}//doGet(-,-)

}//class
