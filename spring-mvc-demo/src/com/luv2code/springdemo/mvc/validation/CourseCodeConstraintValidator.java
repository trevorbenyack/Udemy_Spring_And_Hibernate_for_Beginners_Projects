package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix; // holds what is passed in from our annotation
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		
		coursePrefix = theCourseCode.value();
	}
	
//	// Use to validate against multiple strings
//	private String[] coursePrefixes; 
//	@Override
//	public void initialize(CourseCode theCourseCode) {
//		coursePrefixes = theCourseCode.value();
//	}
	
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) { 
		// theCode is HTML form data entered by the user
		// theConstraintValidatorContext can have additional error messages placed here
		
		// Validation logic
		// Test if the form data starts with our course prefix
		boolean result;
		
		if (theCode != null) {
			result = theCode.startsWith(coursePrefix); // does it start with "LUV"?
		} else {
			result = true; // this is true bc we're not requiring this field
		}
		
//		// Validate against multiple strings:
//		if (theCode != null) {
//			
//			//
//			// loop thru course prefixes
//			//
//			// check to see if code matches any of the course prefixes
//			//
//			for (String tempPrefix : coursePrefixes) {
//				result = theCode.startsWith(tempPrefix);
//				
//				// if we found a match then break out of the loop
//				if (result) {
//					break;
//				}
//			}
//		}
//		else {
//			result = true;
//		}
		
		
		return result;
	}

}
