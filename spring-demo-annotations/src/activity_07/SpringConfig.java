package activity_07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

@Configuration
public class SpringConfig {

	// manually defines a bean for the chineseFortuneService
	@Bean
	public FortuneService chineseFortuneService() {
		return new ChineseFortuneService();
	}
	
	// creates a BasketballCoach bean and injects the chineseFortuneService dependency
	@Bean
	public Coach BasketballCoach() {
		return new BasketballCoach(chineseFortuneService());
		
	}
	
}
