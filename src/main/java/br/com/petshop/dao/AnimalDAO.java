package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.petshop.model.Animal;
import br.com.petshop.util.JpaUtil;

public class AnimalDAO {
	
	private EntityManager manager;
	private EntityTransaction trx;
	
	public AnimalDAO() {
		this.manager = JpaUtil.geEntityManager();
		this.trx = this.manager.getTransaction();
	}
	
	public void salvar(Animal animal) {
		this.trx.begin();
		this.manager.persist(animal);
		this.trx.commit();
	}
	
	public List<Animal> lista(){
		List<Animal> animais = new ArrayList<Animal>();
		this.trx.begin();
		TypedQuery<Animal> query = this.manager.createQuery("from Animal", Animal.class);
		animais = query.getResultList();
		this.trx.commit();
		return animais;
	}
	
	public void deletar(Animal animal) {
		this.trx.begin();
		this.manager.remove(this.manager.contains(animal) ? animal : this.manager.merge(animal));
		this.trx.commit();
	}

	public void atualizar(Animal animal) {
		this.trx.begin();
		this.manager.merge(animal);
		this.trx.commit();
	}

}
