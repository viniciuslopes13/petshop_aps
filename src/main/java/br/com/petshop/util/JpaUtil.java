package br.com.petshop.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("petshop_aps");
	}
	
	public static EntityManager geEntityManager() {
		return factory.createEntityManager();
	}
	
}
