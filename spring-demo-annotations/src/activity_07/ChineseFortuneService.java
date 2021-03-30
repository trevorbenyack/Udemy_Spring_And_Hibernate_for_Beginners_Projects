package activity_07;

import com.luv2code.springdemo.FortuneService;

public class ChineseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "The early bird gets the worm, but the second mouse gets the cheese.";
	}

}
