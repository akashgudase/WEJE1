package com.jspiders.onetoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoonebi.dto.Aadhar;
import com.jspiders.onetoonebi.dto.Person;

public class PersonDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Ramesh");
		person.setEmail("ramesh@gmail.com");
		person.setMobile(9876543210l);

		Aadhar aadhar = new Aadhar();
		aadhar.setAadharNumber(123456789876l);
		aadhar.setPerson(person);

		person.setAadhar(aadhar);

		openConnection();
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(aadhar);
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
