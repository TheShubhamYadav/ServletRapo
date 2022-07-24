package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/errorurl",name = "error")
public class ErrorServlet extends HttpServlet {

       

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doGet()");
	       //get PrintWriter 
		  PrintWriter pw=res.getWriter();
		  //set response content type
		  res.setContentType("text/html");
		  //write message
		  pw.println("<h1 style='color:red;text-align:center'> Internal Problem  -- Try again  </h1>");
		  pw.println("<br> <a href='form.html'> home </a>");
		  //close stream
		  pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doPost()");
          doGet(req,res);
	}//doPost(-,-)

}//class
