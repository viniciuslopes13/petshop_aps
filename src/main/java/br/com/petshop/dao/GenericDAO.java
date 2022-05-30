package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.petshop.util.JpaUtil;

public class GenericDAO {

	private EntityManager manager;
	private EntityTransaction trx;
	
	public GenericDAO() {
		this.manager = JpaUtil.geEntityManager();
		this.trx = this.manager.getTransaction();
	}
	
	public void salvar(Object obj) {
		this.trx.begin();
		this.manager.persist(obj);
		this.trx.commit();
	}
	
	public List<Object> lista(String tipo){
		List<Object> objs = new ArrayList<>();
		this.trx.begin();
		TypedQuery<Object> query = this.manager.createQuery("from "+tipo, Object.class);
		objs = query.getResultList();
		this.trx.commit();
		return objs;
	}
	
	public void deletar(Object obj) {
		this.trx.begin();
		this.manager.remove(this.manager.contains(obj) ? obj : this.manager.merge(obj));
		this.trx.commit();
	}

	public void atualizar(Object obj) {
		this.trx.begin();
		this.manager.merge(obj);
		this.trx.commit();
	}
	
	
}
