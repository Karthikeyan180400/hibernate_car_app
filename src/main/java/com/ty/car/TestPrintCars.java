package com.ty.car;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestPrintCars {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String sql = "select c from Car c where brand=?1 and type=?2";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, "Maruti");
		query.setParameter(2, "Diesel");
		
		 List<Car> list = query.getResultList();
		 if(list.size() > 0) {
			 for(Car car : list) {
				 System.out.println("ID is "+car.getId());
				 System.out.println("Name is "+car.getName());
				 System.out.println("Brand is "+car.getBrand());
				 System.out.println("Type is "+car.getType());
				 System.out.println("Cost is "+car.getCost());
			 }
		 } else {
			 System.out.println("Thers is no car in the brand and type");
		 }

	}

}
