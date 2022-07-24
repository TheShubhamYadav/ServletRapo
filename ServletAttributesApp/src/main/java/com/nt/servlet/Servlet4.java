//Servlet4.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/s4url")
public class Servlet4 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  //get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read request attribute vlaues
		pw.println("<br><b> Servlet4:: attr1 (req) value :: "+req.getAttribute("attr1")+"</b>");
		
		//To read and access Session attribute value
				HttpSession ses=req.getSession();
				pw.println("<br><b> Servlet4:: attr2 (ses) value :: "+ses.getAttribute("attr2")+"</b>");
				
				  //To read and access  ServletContext attribute value
		ServletContext sc=getServletContext();
			pw.println("<br><b> Servlet4:: attr3 (sc) value :: "+sc.getAttribute("attr3")+"</b>");
						
	}//doGet(-,-)
	
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          doGet(req,res);
	}//doPost(-,-)

}//class
