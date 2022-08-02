//SecondServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// read form2/req2 data
		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");
		// read form1/req1 data  (session tracking)
		String name=req.getParameter("hname");
		String fname=req.getParameter("hfname");
		String ms=req.getParameter("hms");
		
		//display dynamic web page having form1/req1 and form2/req2 data
		pw.println("<h1> form1/req1 data ::"+name+"...."+fname+"....."+ms+"</h1>");
		pw.println("<h1> form2/req2 data ::"+f2val1+" ..."+f2val2+"</h1>");
		
				
		//add home hyperlink
		pw.println("<br><a href='details.html'>home </a>");
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
