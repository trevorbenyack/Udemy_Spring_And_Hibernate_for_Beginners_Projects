package PracticeActivity08;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CRUD_EmployeeActivityApp {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		
		
		try {
			// SAVE EMPLOYEES
			
			// create session
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee employee01 = new Employee("Janet", "Red", "Apple");
			Employee employee02 = new Employee("Jared", "Orange", "Cisco");
			Employee employee03 = new Employee("Jennifer", "Yellow", "Microsoft");
			Employee employee04 = new Employee("Jake", "Green", "Apple");
			
			// save employees to session
			session.save(employee01);
			session.save(employee02);
			session.save(employee03);
			session.save(employee04);
			
			session.getTransaction().commit();
			
			// query students
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Object> employeesList = session.createQuery("FROM Employee").getResultList();
			displayResults(employeesList);
			session.getTransaction().commit();
			
			// Retrieve employee by primary key
			session = factory.getCurrentSession();
			session.beginTransaction();
			employeesList = session.createQuery("FROM Employee WHERE id='3'").getResultList();
			displayResults(employeesList);
			session.getTransaction().commit();
			
			
			// Query to find employees of a given company
			session = factory.getCurrentSession();
			session.beginTransaction();
			employeesList = session.createQuery("FROM Employee WHERE company='Apple'").getResultList();
			displayResults(employeesList);
			session.getTransaction().commit();
			
			// Delete an employee by primary key
			session = factory.getCurrentSession();
			session.beginTransaction();
			Employee tempEmployee = session.get(Employee.class, "1");
			session.delete(tempEmployee);
			session.getTransaction().commit();

			
		} finally {
			factory.close();
		}
	
	}
	
	private static void displayResults(List<Object> theObjects) {
		for (Object tempObject : theObjects) {
			System.out.println(tempObject);
		}
	}

}
