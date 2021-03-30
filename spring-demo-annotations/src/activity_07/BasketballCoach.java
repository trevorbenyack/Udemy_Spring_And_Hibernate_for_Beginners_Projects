package activity_07;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

public class BasketballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BasketballCoach (FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Put the ball through the net";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
