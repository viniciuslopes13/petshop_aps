package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.petshop.model.CarteiraVacina;
import br.com.petshop.model.ReservaVagaHotel;
import br.com.petshop.model.VagaHotel;
import br.com.petshop.util.JpaUtil;

public class VagaHotelDAO {
	
	private EntityManager manager;
	private EntityTransaction trx;
	
	public VagaHotelDAO() {
		this.manager = JpaUtil.geEntityManager();
		this.trx = this.manager.getTransaction();
	}
	
	public VagaHotel findById(int id) {
		this.trx.begin();
		VagaHotel vaga = this.manager.find(VagaHotel.class, id);
		this.trx.commit();
		return vaga;
	}

	public List<ReservaVagaHotel> findByData(Date dataBusca) {
		this.trx.begin();
		List<ReservaVagaHotel> reservas = new ArrayList<ReservaVagaHotel>();
		TypedQuery<ReservaVagaHotel> query = this.manager.createQuery("from ReservaVagaHotel where dataEntrada = :dataBusca", ReservaVagaHotel.class)
				.setParameter("dataBusca", dataBusca);
		reservas = query.getResultList();
		this.trx.commit();
		return reservas;
	}
}
