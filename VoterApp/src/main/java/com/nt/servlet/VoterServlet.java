//VoterServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet.doPost(-,-)");
	   //get PrintWriter obj
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data (req param values from request obj)
		String name=req.getParameter("pname");
		String tage=req.getParameter("page");
		int age=Integer.parseInt(tage);
		//write b.logic
		if(age>=18) {
			pw.println("<h1 style='color:green;text-align:center'> Mr/Miss/Mrs."+name+"   u r elgible for  Voting </h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'> Mr/Miss/Mrs."+name+"   u r not elgible for  Voting </h1>");
		}
		
		// grphical hyperlink (image as the hyperlink)
		pw.println("<a href='details_form.html'> <img src='images/home.png' width='100' height='200'> </a>");
		
		 String browser=req.getHeader("user-agent");
		 String language=req.getHeader("accept-language");
		 pw.println("<br>browser name::"+browser);
		 pw.println("<br>language name::"+language);
		 
				 
		
		//close stream
		pw.close();
	}//doPost(-,-)
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet.doGet()");
		   doPost(req,res);
	  }//doGet(-,-)

}//class
