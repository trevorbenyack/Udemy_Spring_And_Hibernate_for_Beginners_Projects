
package com.luv2code.springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * @author trevorbenyack
 *
 * This class reads three fortunes from a file, saves them in an array
 * and then serves a random fortune when called.
 *
 */

@Component // Tells Spring that this will be a bean
public class FileRandomFortuneService implements FortuneService{

	// fortunes array will hold the fortunes read from the file
	private String[] fortunes = new String[3];
	
	@PostConstruct // runs before this dependency is injected
	public void readFile() {
		
		// creates a new file object
		File fortunesFile = new File("src/fortunesFile.txt");
		
		// diagnostic tool for determining current working directory
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		
		try {
			
			// creates new scanner object from fortunesFile object
			Scanner input = new Scanner(fortunesFile);
			
			// reads each line from the input object and assigns it to fortunes[]
			int i = 0;
			while (input.hasNextLine()) {
				fortunes[i] = input.nextLine();
				i++;
			}
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String getFortune() {
		
		// returns a random fortune
		return fortunes[(int)(Math.random()*3)];
	}

}
