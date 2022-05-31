package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.petshop.model.Animal;
import br.com.petshop.model.CarteiraVacina;
import br.com.petshop.util.JpaUtil;

public class CarteiraVacinaDAO {

	private EntityManager manager;
	private EntityTransaction trx;
	
	public CarteiraVacinaDAO() {
		this.manager = JpaUtil.geEntityManager();
		this.trx = this.manager.getTransaction();
	}
	
	public List<CarteiraVacina> findByAnimal(Animal animal){
		this.trx.begin();
		List<CarteiraVacina> vacinas = new ArrayList<CarteiraVacina>();
		TypedQuery<CarteiraVacina> query = this.manager.createQuery("from CarteiraVacina where animal_id = :animal", CarteiraVacina.class)
				.setParameter("animal", animal.getId());
		vacinas = query.getResultList();
		this.trx.commit();
		return vacinas;
	}
}
