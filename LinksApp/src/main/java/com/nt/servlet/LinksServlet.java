//LinksServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read  the "p1" request param value
		String p1val=req.getParameter("p1");
		//differentiate the logics for hyperlinks
		Locale locales[]=Locale.getAvailableLocales();
		if(p1val.equalsIgnoreCase("link1")) {
			pw.println(" <h2> all countries </h2><br>");
			for(Locale l:locales) {
				pw.println(l.getDisplayCountry()+",");
			}//for
		}//if
		else if(p1val.equalsIgnoreCase("link2")){
			pw.println(" <h2> all languages </h2><br>");
			for(Locale l:locales) {
				pw.println(l.getDisplayLanguage()+",");
			}//for
		}
		else {
			pw.println(" <h2> System properites </h2><br>");
			pw.println(System.getProperties());
		}
		
		//add home hyperlink
		pw.println("<br> <a href='links.html'>home </a>");
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req,res);
	}

}
