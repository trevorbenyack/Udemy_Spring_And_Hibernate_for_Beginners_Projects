package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// Step 1 - load the spring configuration file
		// "applicationContext.xml" is the configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Step 2 - retrieve bean from spring container
		// retrieve a ban from spring container
        // "myCoach" is the bean ID, and Coach.class is the interface
        // the interface is specified b/c when passed to the method, Spring casts the object and is able to provide
        // type safety by throwing a BeanNotOfRequiredTypeException if the bean is not of the required type.
		
		// the myCoach bean is given to us fully assembled with the fortuneService dependency injected
		// otherwise, we'd have to create a fortuneService object, then pass it to whichever Coach object we wanted to instantiate
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// Step 3 - call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// Step 4 - close the context
		context.close();
		
	}

}
