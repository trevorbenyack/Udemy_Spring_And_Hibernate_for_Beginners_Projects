package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

	// define a private field/variable of type FortuneService for the dependency
	private FortuneService fortuneService;
	
	

	// define a constructor for dependency injection -- this is where the dependency is injected
	// aka this is where the dependency is passed in and then assigned to our local private field
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {

		// use fortuneService to get a fortune
		// the fortuneService dependency is a helper

		return fortuneService.getFortune();
	}

}
