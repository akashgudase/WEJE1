package com.jspiders.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dto.ContactDTO;

@Component
public class ContactDAO {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("contact_manager");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private void closeConnection() {
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

	public void addContact(ContactDTO contactDTO) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(contactDTO);
		entityTransaction.commit();
		closeConnection();
	}

	@SuppressWarnings("unchecked")
	public List<ContactDTO> findAllContacts() {
		openConnection();
		Query query = entityManager.createQuery("SELECT contact FROM ContactDTO contact");
		List<ContactDTO> contacts = query.getResultList();
		closeConnection();
		return contacts;
	}

	public ContactDTO deleteContact(int id) {
		openConnection();
		ContactDTO contact = entityManager.find(ContactDTO.class, id);
		if (contact != null) {
			entityTransaction.begin();
			entityManager.remove(contact);
			entityTransaction.commit();
		}
		return contact;
	}

	public ContactDTO findContactById(int id) {
		openConnection();
		ContactDTO contact = entityManager.find(ContactDTO.class, id);
		closeConnection();
		return contact;
	}

	public void updateContact(int id, String firstName, String lastName, String email, long mobile) {
		openConnection();
		ContactDTO contact = entityManager.find(ContactDTO.class, id);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		contact.setMobile(mobile);
		entityTransaction.begin();
		entityManager.persist(contact);
		entityTransaction.commit();
	}

}
