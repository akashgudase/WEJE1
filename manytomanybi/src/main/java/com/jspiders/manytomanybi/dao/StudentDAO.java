package com.jspiders.manytomanybi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomanybi.dto.Student;
import com.jspiders.manytomanybi.dto.Subject;

public class StudentDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setName("Ramesh");
		student1.setEmail("ramesh@gmail.com");
		student1.setMobile(98765432190l);

		Student student2 = new Student();
		student2.setName("Suresh");
		student2.setEmail("suresh@gmail.com");
		student2.setMobile(98765432191l);

		Subject subject1 = new Subject();
		subject1.setName("SQL");
		subject1.setFees(10000);

		Subject subject2 = new Subject();
		subject2.setName("CORE JAVA");
		subject2.setFees(15000);

		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);

		List<Subject> subjects = new ArrayList<>();
		subjects.add(subject1);
		subjects.add(subject2);

		student1.setSubjects(subjects);
		student2.setSubjects(subjects);

		subject1.setStudents(students);
		subject2.setStudents(students);

		openConnection();
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(subject1);
		entityManager.persist(subject2);
		entityTransaction.commit();
		closeConnection();
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}

	}

}
