package com.jspiders.hibetnate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibetnate.dto.Contact;

public class ContactMain {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {

		Contact contact = new Contact();
		contact.setFirstName("Umesh");
		contact.setLastName("Yadav");
		contact.setEmail("umesh@gmail.com");
		contact.setMobile(9876543213l);
		openConnection();
		entityTransaction.begin();
		entityManager.persist(contact);
		entityTransaction.commit();
		closeConnection();

	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("contact_manager");
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
