package br.com.petshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.petshop.model.ClienteUser;
import br.com.petshop.util.JpaUtil;

public class CriarTabelasBD {

	public static void main(String[] args) {
		EntityManager entityManager = JpaUtil.geEntityManager();
		EntityTransaction trx = entityManager.getTransaction();
		
		ClienteUser teste = new ClienteUser();
		teste.setNome("vincius");
		teste.setEmail("vinci@gmail.com");
		teste.setTelefone("99248932");
		teste.setEndereco("Sítio ");
		
		trx.begin();
		entityManager.persist(teste);
		trx.commit();
		entityManager.close();
		
	}

}
