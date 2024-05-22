package com.jspiders.onetomanybi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomanybi.dto.Company;
import com.jspiders.onetomanybi.dto.Employee;

public class CompanyDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		Company company = new Company();
		company.setName("Tata");
		company.setLocation("Pune");

		Employee employee1 = new Employee();
		employee1.setName("Ramesh");
		employee1.setEmail("ramesh@gmail.com");
		employee1.setMobile(9876543210l);
		employee1.setCompany(company);

		Employee employee2 = new Employee();
		employee2.setName("Suresh");
		employee2.setEmail("suresh@gmail.com");
		employee2.setMobile(9876543211l);
		employee2.setCompany(company);

		List<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);

		company.setEmployees(employees);

		openConnection();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
		closeConnection();

	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("company");
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
