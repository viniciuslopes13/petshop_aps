package br.com.petshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.petshop.model.ClienteUser;
import br.com.petshop.util.JpaUtil;

public class ClienteDAO {
	
	private EntityManager manager;
	private EntityTransaction trx;
	
	public ClienteDAO() {
		this.manager = JpaUtil.geEntityManager();
		this.trx = this.manager.getTransaction();
	}
	
	public void salvar(ClienteUser cliente) {
		this.trx.begin();
		this.manager.persist(cliente);
		this.trx.commit();
	}
	
}
