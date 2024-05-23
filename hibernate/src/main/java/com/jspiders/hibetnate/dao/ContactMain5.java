package com.jspiders.hibetnate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibetnate.dto.Contact;

public class ContactMain5 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {

		openConnection();
		Query query = entityManager.createQuery("SELECT contact FROM Contact contact");
		@SuppressWarnings("unchecked")
		List<Contact> contacts = query.getResultList();
		if (contacts.size() > 0) {
			for (Contact contact : contacts) {
				System.out.println(contact);
			}
		} else {
			System.out.println("Contacts do not exist");
		}
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
