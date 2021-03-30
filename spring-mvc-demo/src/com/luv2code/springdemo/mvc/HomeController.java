package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. Create Controller class
@Controller
public class HomeController {
	
	// 2. Define controller method
	// 3. Add Request mapping to Controller method
	@RequestMapping("/") // root directory
	public String showPage() {
		
		// 4. Return view name
		return "main-menu";
	}

}
