//FindCapitalServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindCapitalServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //get PrintWriter
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //  read form  data
		 int countryCode=Integer.parseInt(req.getParameter("country"));
		 //  prepare capitals
		 String  countries[]=new String[] {"INDIA","USA","CHINA","CANADA"};			 
		 String capitals[]=new String[] {"New Delhi"," WashingtonDC","Bejing","Ottawa"};
		 //display capital
		 pw.println("<h1 style='color:red;text-align:center'> The Capital city name of "+countries[countryCode]+"  is ::"+capitals[countryCode]+"</h1>");
		 
		 //add home hperlink
		 pw.println("<a href='input.html'><h2 style='text-align:center'>home </h2></a>");
		 
		 //close stream
		 pw.close();
		  
	}//doGet(-,-)
	

}//class
