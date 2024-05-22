package com.jspiders.onetooneuni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetooneuni.dto.Aadhar;
import com.jspiders.onetooneuni.dto.Person;

public class PersonDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		Aadhar aadhar = new Aadhar();
		aadhar.setAadharNumber(123456789875l);

		Person person = new Person();
		person.setName("Suresh");
		person.setEmail("suresh@gmail.com");
		person.setMobile(9876543211l);
		person.setAadhar(aadhar);

		openConnection();
		entityTransaction.begin();
		entityManager.persist(aadhar);
		entityManager.persist(person);
		entityTransaction.commit();
		closeConnection();
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("person");
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
