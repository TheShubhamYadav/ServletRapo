//NewInstanceMethodTest.java
package com.nt.test;

import java.lang.reflect.Constructor;

public class NewInstanceMethodTest {

	public static void main(String[] args) {
		
		try {
			//Load the java class
			Class c=Class.forName(args[0]);
			//get all construructors of the class
			Constructor cons[]=c.getDeclaredConstructors();
			//  create the object
			Object obj=cons[0].newInstance();  //creates obj using 0-param constructor
			System.out.println(obj);
			System.out.println("-------------------");
			Object obj1=cons[1].newInstance(10,20); ////creates obj using 2-param constructor
			System.out.println(obj1);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
