//VoterServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		
		//read  hidden value as req param value indicating  wheather client side form validation
		//or done nor not
		float age=0.0f;
	String  vstatus=req.getParameter("vstatus"); //gives yes or no
	System.out.println(vstatus);
	if(vstatus.equalsIgnoreCase("no")) {
	
       //  Server side form validation logics
		System.out.println("Server side form validation logics..");
		List<String>  errorsList=new ArrayList();
		if(name==null || name.equals("") ||  name.length()==0)  //required  rule on  name
			  errorsList.add("Person  name is required");
		else if(name.length()<5 || name.length()>10)  // minlegnth , max length rule on name
			 errorsList.add("Person  name must contain minimum of 5 chars and max of  10 chars" );
		
		if(tage==null ||  tage.equals("") || tage.length()==0)  //required rule on age
			errorsList.add("Person  age  is required");
		else {
			try {
			 age=Float.parseFloat(tage);
			    if (age<0 ||  age>100) {  // age range rule
			    	errorsList.add("Person  age must be there in the range of 1 through 100");
			    }
			}
			catch(NumberFormatException nfe) {
				errorsList.add("Person  age  must be numeric value");  // age must be numeric vlaue rule
			}
		}
		
		// display  form validation error messages
		  if(errorsList.size()>0) {
			    for(String msg:errorsList) {
			    	pw.println("<li style='color:red'><b> "+msg+"</li></b>");
			    }//for
			    return;   // if form validation errors are raised  this  return<without value> returns the control back to caller
			                      //  with out executing further logics  (indirectly  stops  the execution in servlet comp )
		  } 
	}//if
	else {
		age=Float.parseFloat(tage);  //covert String float value to real float value
	}
	
		//write b.logic
		if(age>=18) {
			pw.println("<h1 style='color:green;text-align:center'> Mr/Miss/Mrs."+name+"   u r elgible for  Voting </h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'> Mr/Miss/Mrs."+name+"   u r not elgible for  Voting </h1>");
		}
	
		
		// grphical hyperlink (image as the hyperlink)
		pw.println("<a href='details_form.html'> <img src='images/home.png' width='100' height='200'> </a>");
		
		pw.println("<br> <b> request obj class name ::"+req.getClass()+"</b>");
		pw.println("<br> <b> response obj class name ::"+res.getClass()+"</b>");
		
		
		//close stream
		pw.close();
	}//doPost(-,-)
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet.doGet()");
		   doPost(req,res);
	  }//doGet(-,-)

}//class
