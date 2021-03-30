package activity_07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.springdemo.Coach;

public class App {

	public static void main(String[] args) {
		
		// Loads Spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		// gets a BasketballCoach bean from the Spring container
		Coach theCoach = context.getBean("BasketballCoach", Coach.class);
		
		System.out.println("Today's workout: " + theCoach.getDailyWorkout());
		System.out.println("Today's fortune: " + theCoach.getDailyFortune());
		
		// close the context
		context.close();

	}

}
