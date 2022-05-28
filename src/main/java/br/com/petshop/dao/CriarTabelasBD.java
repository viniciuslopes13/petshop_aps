package br.com.petshop.dao;

import javax.persistence.Persistence;

public class CriarTabelasBD {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("petshop_aps");
	}

}
