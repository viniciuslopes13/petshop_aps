package br.com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
	
	public List<ClienteUser> lista(){
		List<ClienteUser> clientes = new ArrayList<ClienteUser>();
		this.trx.begin();
		TypedQuery<ClienteUser> query = this.manager.createQuery("from ClienteUser", ClienteUser.class);
		clientes = query.getResultList();
		this.trx.commit();
		return clientes;
	}
	
	public void deletar(ClienteUser cliente) {
		this.trx.begin();
		this.manager.remove(this.manager.contains(cliente) ? cliente : this.manager.merge(cliente));
		this.trx.commit();
	}

	public void atualizar(ClienteUser clienteSelecionado) {
		this.trx.begin();
		this.manager.merge(clienteSelecionado);
		this.trx.commit();
	}
}
