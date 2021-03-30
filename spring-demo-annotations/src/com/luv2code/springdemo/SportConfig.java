package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // tells Spring that this a java configuration and to follow the directions in this file
// @ComponentScan("com.luv2code.springdemo") //com.luv2code.springdemo is the name of the package to start scanning. Scans for the @Component annotation.
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// manually define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService()); // this calls the bean method above
	}

}
