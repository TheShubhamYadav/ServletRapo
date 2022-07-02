package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
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
		     //get Access to ServletConfig obj
		     ServletConfig cg=getServletConfig();
		     //read init param value
		     pw.println("<b> TestServlet:: dbuser init param value ::"+cg.getInitParameter("dbuser")+"</b>");
		     pw.println("<br><b> TestServlet::  logical name or instance name ::"+cg.getServletName()+"</b>");
		     pw.println("<br> ServletConfig obj class name ::"+cg.getClass()+"</b>");
		     
		     //close stream
		     pw.close();
		     
	}//doGet(-,-)

}//class
