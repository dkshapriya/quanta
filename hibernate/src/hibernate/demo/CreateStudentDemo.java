package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try { 
			
			System.out.println("Creating new student object");
			Student tempStudent = new Student("Diksha","Tiwari","diksha.priya@mavenwave.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student");
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Sucess");
		}
		finally {
			factory.close();
		}

	}

}
