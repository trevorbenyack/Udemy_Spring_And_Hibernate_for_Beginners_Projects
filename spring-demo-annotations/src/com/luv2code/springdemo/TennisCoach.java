package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// this will now use tennisCoach as Bean ID
@Component
//@Scope("prototype") // creates a new instance every time this bean is retrieved
public class TennisCoach implements Coach {
	
	// FIELD INJECTION
	@Autowired
	@Qualifier("fileRandomFortuneService")
	private FortuneService fortuneService;
	
	
	
	public TennisCoach() {
		System.out.println(">> TennisCoach inside default constructor");
	}
	
	// init method example
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach inside of doMyStartupStuff()");
	}
	
	// destroy method example
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
	

	/*
	 * // CONSTRUCTOR INJECTION 
	 * // Create a constructor in the class for injections
	 * // Spring scans for a component that implements the FortuneService interface
	 * 
	 * @Autowired 
	 * public TennisCoach(FortuneService theFortuneService) {
	 * fortuneService = theFortuneService; }
	 */
	
	
	/*
	 * // SETTER INJECTION 
	 * // define a setter method
	 * 
	 * @Autowired 
	 * public void setFortuneService(FortuneService theFortuneService) {
	 * this.fortuneService = theFortuneService;
	 * System.out.println(">> TennisCoach inside setFortuneService() method"); }
	 */
	
	/*
	 * // METHOD INJECTION
	 * 
	 * @Autowired 
	 * public void doSomeCrazyStuff(FortuneService theFortuneService) {
	 * 
	 * System.out.println(">> TennisCoach inside doSomeCrazyStuff() method");
	 * fortuneService = theFortuneService; }
	 */
	 

	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	

}
