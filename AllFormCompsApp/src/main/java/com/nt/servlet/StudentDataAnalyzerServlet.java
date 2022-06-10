//StudentDataAnalyzerServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentDataAnalyzerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		 String name=req.getParameter("sname");
		 String addrs=req.getParameter("sadd");
		 String gender=req.getParameter("gender");
		 String email=req.getParameter("email");
		 String qlfy=req.getParameter("qlfy");
		 long  contactNo=Long.parseLong(req.getParameter("contactNo"));
		 String  hobies[]=req.getParameterValues("hb");
		 if(hobies==null)
			 hobies=new String[] {"no hobiles are selected"};
		 String  favColors[]=req.getParameterValues("favColors");
		   if(favColors==null)
			   favColors=new String[] {" No favorite colors are selected"};
			 String ms=req.getParameter("ms");
			  if(ms==null)
				  ms="single";
			  
		 String   dob=req.getParameter("dob");  //gives yyyy-mm-dd 
		 String nickname=req.getParameter("petname");
		 String  mob =req.getParameter("mob");
		 String tob=req.getParameter("tob");
		 String wob=req.getParameter("wob");
		 String scolor=req.getParameter("scolor");
		 long salary =Long.parseLong(req.getParameter("salrange"));
		 String ss=req.getParameter("ss");
		 int favNo=Integer.parseInt(req.getParameter("favNo"));
		 String fburl=req.getParameter("fburl");
	
		 //calculate the age of a person
		   java.util.Date udob=java.sql.Date.valueOf(dob);  //converts string date of yyyy-mm-dd pattern to
		                                                                                                    //java.sql.Date class obj
		   java.util.Date sysDate=new java.util.Date();  //system date and time
		   double age= (sysDate.getTime()-udob.getTime())/(1000.0*60.0*60.0*24.0*365.25);
		   //  write analyzation of data
		   if(gender.equalsIgnoreCase("M")) {
			   if(age<5)
				   pw.println("<h1>Master."+name+"  u  r  baby boy </h1>");
			   else if(age<13)
				   pw.println("<h1>Master."+name+"  u  r  small boy </h1>");
			   else if(age<20)
				   pw.println("<h1>Master."+name+"  u  r  teenage boy </h1>");
			   else if(age<35)
				   pw.println("<h1>Master."+name+"  u  r  young man </h1>");
			   else if(age<50)
				   pw.println("<h1>Master."+name+"  u  r  middle-aged man </h1>");
			   else
				   pw.println("<h1>Master."+name+"  u  r  old man </h1>");
		   }//if
		   else {
			   if(age<5)
				   pw.println("<h1>Master."+name+"  u  r  baby girl </h1>");
			   else if(age<13)
				   pw.println("<h1>Master."+name+"  u  r  small girl </h1>");
			   else if(age<20) {
				   if(ms.equalsIgnoreCase("married"))
				        pw.println("<h1>Mrs."+name+"  u  r  teenage girl </h1>");
				   else
					   pw.println("<h1>Miss."+name+"  u  r  teenage girl </h1>");
			   }
			   else if(age<35) {
				   if(ms.equalsIgnoreCase("married"))
				        pw.println("<h1>Mrs."+name+"  u  r  young woman </h1>");
				   else
					   pw.println("<h1>Miss."+name+"  u  r  young woman </h1>");
			   }
			   else if(age<50) {
				   if(ms.equalsIgnoreCase("married"))
				        pw.println("<h1>Mrs."+name+"  u  r  middle-aged woman </h1>");
				   else
					   pw.println("<h1>Miss."+name+"  u  r  middle-aged woman </h1>");
			   }
			   else {
				   if(ms.equalsIgnoreCase("married"))
				        pw.println("<h1>Mrs."+name+"  u  r  old woman </h1>");
				   else
					   pw.println("<h1>Miss."+name+"  u  r  old woman </h1>");
			   }
		   }
		   
		   //display the recieved form data
		   pw.println("<h1 style='color:blue'> The form data  is  </h1>");
		   pw.println("<br><b> name ::"+name+"</b>");
		   pw.println("<br><b> address ::"+addrs+"</b>");
		   pw.println("<br><b> contact number ::"+contactNo+"</b>");
		   pw.println("<br><b> gender ::"+gender+"</b>");
		   pw.println("<br><b> marital status ::"+ms+"</b>");
		   pw.println("<br><b> email ::"+email+"</b>");
		   pw.println("<br><b> DOB ::"+dob+"</b>");
		   pw.println("<br><b> Time of Birth(TOB) ::"+tob+"</b>");
		   pw.println("<br><b> Month of Birth(MOB) ::"+mob+"</b>");
		   pw.println("<br><b> Week of Birth(WOB) ::"+wob+"</b>");
		   pw.println("<br><b> Qualification ::"+qlfy+"</b>");
		   pw.println("<br><b> Favorite colors ::"+Arrays.toString(favColors)+"</b>");
		   pw.println("<br><b> hobies ::"+Arrays.toString(hobies)+"</b>");
		   pw.println("<br><b> nick name ::"+nickname+"</b>");
		   pw.println("<br><b> Favorite Number ::"+favNo+"</b>");
		   pw.println("<br><b> Sentiment Color ::"+scolor+"</b>");
		   pw.println("<br><b> Expected salary ::"+salary+"</b>");
		   pw.println("<br><b> FB URL ::"+fburl+"</b>");
		   pw.println("<br><b> Google Search String ::"+ss+"</b>");
		    
		   //add home hyperlink
		   pw.println("<br><br> <a href='student_registration.html'>home </a>");
		   
		   //close the stream
		   pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class
