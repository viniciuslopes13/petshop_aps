package br.com.petshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.petshop.model.Servico;
import br.com.petshop.util.JpaUtil;

public class ServicoDAO {


	private EntityManager manager;
	private EntityTransaction trx;
	
	public ServicoDAO() {
		this.manager = JpaUtil.geEntityManager();
		this.trx = this.manager.getTransaction();
	}
	
	public Servico findById(int id) {
		this.trx.begin();
		Servico servico = this.manager.find(Servico.class, id);
		this.trx.commit();
		return servico;
	}
	
}
