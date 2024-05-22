package com.jspiders.manytomanybi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomanybi.dto.Student;
import com.jspiders.manytomanybi.dto.Subject;

public class SubjectDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		openConnection();
		Subject subject = entityManager.find(Subject.class, 2);
//		List<Student> students = subject.getStudents();
//		for (Student student : students) {
//			List<Subject> subjects = student.getSubjects();
//			subjects.remove(subject);
//			entityTransaction.begin();
//			entityManager.persist(student);
//			entityTransaction.commit();
//		}
//		subject.setStudents(null);
//		entityTransaction.begin();
//		entityManager.persist(subject);
//		entityTransaction.commit();
		entityTransaction.begin();
		entityManager.remove(subject);
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
