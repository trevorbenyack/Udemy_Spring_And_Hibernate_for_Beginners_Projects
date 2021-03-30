package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // Helper class that contains business rules / validation logic
@Target( {ElementType.METHOD, ElementType.FIELD }) // where we apply this new annotation
@Retention(RetentionPolicy.RUNTIME) // how long the annotation be stored/used -> store in bytecode and process it at runtime
public @interface CourseCode {
	
	// value() and message() are for people actually using the annotation
	// define default course code
	public String value() default "LUV"; // value() is what the user can pass in for "value" -- defaults to "LUV"
	
//	// VALIDATE AGAINST MULTIPLE STRINGS:
//	public String[] value() default {"LUV"};
	
	// define default error message
	public String message() default "must start with LUV"; // message() is what the user can pass in for "message"
	
	// We're not using either of these in this example... just using defaults
	// define default groups -- where validation constraints can be grouped together
	public Class<?>[] groups() default {};
	
	// define default payloads -- where you can give additional information about the validation error
	public Class<? extends Payload>[] payload() default {}; // use the javax.validation import
}
