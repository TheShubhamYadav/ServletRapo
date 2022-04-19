package com.nt.basics;

import java.text.SimpleDateFormat;

public class DateValuesTest {

	public static void main(String[] args) throws Exception{
		//converting string date value to java.util.Date class obj
		 String d1="21-55-1980";  //MM-dd-yyyy
		 SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
		 java.util.Date ud1=sdf.parse(d1);
		 System.out.println("String date value::"+d1);
		 System.out.println("Util Date vlaue ::"+ud1);
		 System.out.println(".......................");
			//converting java.util.Date class obj to java.sql.Date class obj
		 long ms=ud1.getTime();
		 java.sql.Date sqd=new  java.sql.Date(ms);
		 System.out.println("sql date ::"+sqd);
             //if the given String value format is  yyyy-MM-dd then it can be coverted
		   //directly to  java.sql.Date  class obj  by using its valueOf(-) method
		  String d2="1996-11-23";  //yyyy-MM-dd
		  java.sql.Date sqd1=java.sql.Date.valueOf(d2);
		  System.out.println("String date value ::"+d2);
		  System.out.println("sql date value is ::"+sqd1);
		  
		  //converting  java.sql.Date class obj to java.util.Date class obj
		  java.util.Date ud2=sqd1;
		  System.out.println("util date:: "+ud2);
		  //converting  java.util.Date class object to String date value
		  SimpleDateFormat sdf2=new SimpleDateFormat("MMM-yyyy-dd");
		  String sd3=sdf2.format(ud2);
		  System.out.println("String date value ::"+sd3);
		  

	}

}
