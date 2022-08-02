//FirstServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// create cookies
		  Cookie ck1=new Cookie("ap","amaravathi");
		  Cookie ck2=new Cookie("TS","hyd");
		  res.addCookie(ck1); res.addCookie(ck2);  //InMemory cookies
		 
		  Cookie ck3=new Cookie("MH","mumbai");
		  Cookie ck4=new Cookie("Odisha","BBSR");
		  ck3.setMaxAge(1*60); ck4.setMaxAge(2*60);
		  res.addCookie(ck3); res.addCookie(ck4); //Persistence bookies
		  
		  //get PrintWriter 
		  PrintWriter pw=res.getWriter();
		  //set response content type
		  res.setContentType("text/html");
		  
		  //write message to browser
		  pw.println("<br><br> <h1> Cookies are cretes,added to response and stored at client side </h1>");
		  //close 
		  pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class
