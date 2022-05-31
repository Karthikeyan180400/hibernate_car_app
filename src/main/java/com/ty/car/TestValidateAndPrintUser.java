package com.ty.car;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestValidateAndPrintUser {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "select u from User u where u.email=?1 and u.password=?2";

		Query query = entityManager.createQuery(sql);
		query.setParameter(1, "peter@mail.com");
		query.setParameter(2, "12121212");

		List<User> list = query.getResultList();
		if (list.size() > 0) {
			User user = list.get(0);
			System.out.println("ID is " + user.getId());
			System.out.println("Name is " + user.getName());
			System.out.println("Email is " + user.getEmail());
			System.out.println("Gender is " + user.getGender());

		} else {
			System.out.println("Email or Password is incorrect");
		}

	}

}
