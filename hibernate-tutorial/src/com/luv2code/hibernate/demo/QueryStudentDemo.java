package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
		
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName='Doe'
			// The AS clause is used to assign aliases to the classes in HQL Queries, but it is optional
			// with AS clause: "from Student AS s where s.lastName='Doe'"
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
		
			// display the students
			System.out.println("\n\nStudents who have the last name of Doe");
			displayStudents(theStudents);
			
			// query students: lastName='Doe' OR firstName='Daffy'
			theStudents = 
					session.createQuery("from Student s where" +
							" s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			System.out.println("\n\nStudents who have the last name of Doe or first name Daffy");
			displayStudents(theStudents);
			
			// query students: email LIKE '%gmail.com'
			theStudents = 
					session.createQuery("from Student s where " + 
							"s.email LIKE '%gmail.com'").getResultList();
			
			System.out.println("\n\nStudents who have an email ending in 'gmail.com'");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} 
		finally {
			factory.close();
		}
		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
