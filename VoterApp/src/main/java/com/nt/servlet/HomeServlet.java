//HomeServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeServlet extends  HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
        //set content type
		res.setContentType("text/html");
		//write the message
		pw.println("<h1 style='color:red;text-align:center'> Welcome to servlet  </h1>");
		//close the stream
		pw.close();
	}//doGet(-,-)
}//class
