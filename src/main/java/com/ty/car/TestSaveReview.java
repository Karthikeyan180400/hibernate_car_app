package com.ty.car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveReview {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Review review = new Review();
		review.setSubject("Worth For Money");
		review.setContent("Great one from TATA,Good Interiors and Exteriors. 'Big Salute to TATA' ");
		review.setWriterName("Karthi");

		entityTransaction.begin();
		entityManager.persist(review);
		entityTransaction.commit();

	}

}
