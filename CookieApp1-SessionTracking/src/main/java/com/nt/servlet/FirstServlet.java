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
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		//read form data (form1/req1 data)
		 String name=req.getParameter("pname");
		 String fname=req.getParameter("fname");
		 String  ms=req.getParameter("ms");
		 //create InMemory cookies having form1/req1 data
		 Cookie ck1=new Cookie("name",name);
		 Cookie  ck2=new Cookie("fname",fname);
		 Cookie  ck3=new Cookie("ms",ms);
		 //add cookies to the response
		 res.addCookie(ck1);
		 res.addCookie(ck2);
		 res.addCookie(ck3);
		 
		 
		 //generate dynamic form page based on the marital status
		 if(ms.equalsIgnoreCase("single")) {
			 pw.println("<form action='secondurl' method='post'>");
			 pw.println(" <table border='0' bgcolor='cyan' align='center'>");
			 pw.println("<tr><td> when do u want to marry? </td>");
			 pw.println("<td> <input type='text' name='f2t1'> </td> </tr>");
			 pw.println("<tr><td> why do u want to marry? </td>");
			 pw.println("<td> <input type='text' name='f2t2'> </td> </tr>");
			 pw.println("<tr><td colspan='2'> <input type='submit' value='submit'></td> </tr>");
			 pw.println("</table>");
			 pw.println("</form>");
		 }
		 else {
			 pw.println("<form action='secondurl' method='post'>");
			 pw.println(" <table border='0' bgcolor='cyan' align='center'>");
			 pw.println("<tr><td>  spouse name:: </td>");
			 pw.println("<td> <input type='text' name='f2t1'> </td> </tr>");
			 pw.println("<tr><td> No.of children:: </td>");
			 pw.println("<td> <input type='text' name='f2t2'> </td> </tr>");
			 pw.println("<tr><td colspan='2'> <input type='submit' value='submit'></td> </tr>");
			 pw.println("</table>");
			 pw.println("</form>");
		 }//else
		 
		 //close stream
		 pw.close();
		
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class
