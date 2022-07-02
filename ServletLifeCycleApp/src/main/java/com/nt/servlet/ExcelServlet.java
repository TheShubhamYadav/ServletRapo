//ExcelServlet.java
package com.nt.servlet;

 import jakarta.servlet.*;
 import jakarta.servlet.http.*;
 import java.io.*;


public class   ExcelServlet extends HttpServlet
{
	
	static {
		System.out.println("ExcelServlet: static block");
	}
	
	public ExcelServlet() {
		System.out.println("ExecelServlet:: 0-param constructor");
	}
	
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		 System.out.println("ExcelServlet.init(-)");
	}
	
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("ExcelServlet.service()");
          //set response content type
		     res.setContentType("application/vnd.ms-excel");
             // get PrintWriter 
			 PrintWriter pw=res.getWriter();
			 //write content response obj using Printerwriter
			 pw.println("<table border='1' bgcolor='cyan' align='center'>");
			 pw.println("<tr> <th> IPL Team </th> <th> Captain </th> <th> Management </th> </tr>");
			 pw.println("<tr> <td> MI </td> <td> Rohit Sharma </td> <td>  Reliance </td> </tr>");
 			 pw.println("<tr> <td> CSK </td> <td> Dhoni </td> <td>  Indian Cement </td> </tr>");
  			 pw.println("<tr> <td> RCB </td> <td> Duplissis </td> <td>  UBL </td> </tr>");
   			 pw.println("<tr> <td> GT </td> <td> Hardik pandya </td> <td>  CVC Capitals </td> </tr>");
	 		 pw.println("<tr> <td> SRH </td> <td> Williamson </td> <td>  Sun Network </td> </tr>");
			 pw.println("</table>");

			 //close stream
			 pw.close();

	}//service(-,-)

}//class
