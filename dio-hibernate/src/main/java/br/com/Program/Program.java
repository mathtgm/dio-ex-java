package br.com.Program;

import java.sql.SQLException;

import br.com.Course.Course;
import br.com.Student.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("projeto_jpa");
		EntityManager EM = EMF.createEntityManager();
		
		Course course = EM.find(Course.class, 4);
		System.out.println(course);
		
		Query query = EM.createQuery("FROM Student WHERE student_id = :id");
		query.setParameter("id", 4);
		Student student = (Student) query.getSingleResult();
		
		System.out.println(student);
		
		student.setStudent_name("Gabriel");
		EM.merge(student);
		
		Student student2 = (Student) query.getSingleResult();
		System.out.println(student2);
		
		/*
		 * EM.getTransaction().begin();
		 * 
		 * Student student1 = new Student();
		 * student1.setStudent_name("Matheus Gabriel");
		 * student1.setStudent_address("Rua José Bressan");
		 * 
		 * Student student2 = new Student(); student2.setStudent_name("Steffany");
		 * student2.setStudent_address("Rio claro");
		 * 
		 * Professor professor1 = new Professor();
		 * professor1.setProfessor_name("Camillo");
		 * 
		 * Course course1 = new Course();
		 * course1.setCourse_name("Sistemas da informação");
		 * course1.setcourse(professor1); course1.getStudents().add(student1);
		 * course1.getStudents().add(student2);
		 * 
		 * EM.persist(student1); EM.persist(student2); EM.persist(professor1);
		 * EM.persist(course1);
		 * 
		 * EM.getTransaction().commit(); EM.close(); EMF.close();
		 */
	}

}
