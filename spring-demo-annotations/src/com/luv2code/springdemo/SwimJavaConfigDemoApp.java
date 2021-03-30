package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
//		// This was used w/o the properties file. 		
//		// get the bean from the spring container
//		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		// This is used w/ the properties file because the SwimCoach 
		// class has extra methods that the Coach class does not
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call the getter SwimCoach methods w/ the property values injected
		
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		// close the context
		context.close();

	}

}
