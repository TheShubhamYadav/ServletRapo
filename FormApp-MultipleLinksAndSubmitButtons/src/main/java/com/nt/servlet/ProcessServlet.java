package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		 //read s1 req param value
		String s1val=req.getParameter("s1");
		//read form data  only when submit buttons are clicked
		int val1=0,val2=0;
		if(!s1val.equalsIgnoreCase("link1") && !s1val.equalsIgnoreCase("link2")) {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
		}
		//differentiate logics for submit buttons , hyperlinks 
		if(s1val.equalsIgnoreCase("add")) {
			pw.println("<h1> add  :: "+(val1+val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("sub")) {
			pw.println("<h1> Sub  :: "+(val1-val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("mul")) {
			pw.println("<h1> Mul  :: "+(val1*val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("link1")) {
			//system date 
			 LocalDate ldt=LocalDate.now();
			 // current month
			 int month=ldt.getMonthValue();
			 if(month>=3 && month<=6)
				 pw.println("<h1> Summer Season </h1>");
			 else if(month>=7 && month<=10) {
				 pw.println("<h1> Rainy Season </h1>");
			 }
			 else {
				 pw.println("<h1> winter Season </h1>");
			 }
		}//else
		else {
			// get System date and time
			TimeZone zone=TimeZone.getDefault();
			pw.println("<h1> Current Time zone ::"+zone.getDisplayName());
		}
		//add home hyperlink
		pw.println("<br><br> <h1 style='color:red;text-align:center'><a href='form.html'> home</a> </h1>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         doGet(req,res);
	}//doPost(-,-)

}//class
