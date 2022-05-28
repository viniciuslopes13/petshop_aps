package br.com.petshop.dao;

import javax.persistence.EntityManager;

import br.com.petshop.model.ClienteUser;
import br.com.petshop.util.JpaUtil;

public class ClienteDAO {
	
	private EntityManager manager;
	
	public ClienteDAO() {
		this.manager = JpaUtil.geEntityManager();
	}
	
	public void salvar(ClienteUser cliente) {
		this.manager.persist(cliente);
	}
	
}
