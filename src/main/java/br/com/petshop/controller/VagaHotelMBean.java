package br.com.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.GenericDAO;
import br.com.petshop.model.StatusQuarto;
import br.com.petshop.model.VagaHotel;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class VagaHotelMBean {

	private VagaHotel novaVagaHotel;
	private VagaHotel vagaHotelSelecionada;
	private List<Object> listVagasHotel;
	private StatusQuarto[] status;
	
	public VagaHotelMBean() {
		novaVagaHotel = new VagaHotel();
		vagaHotelSelecionada = new VagaHotel();
		listVagasHotel = this.listar();
		status = StatusQuarto.values();
	}
	
	public List<Object> listar(){
		GenericDAO genericDAO = new GenericDAO();
		List<Object> vagasHotel = new ArrayList<>();
		vagasHotel = genericDAO.lista("VagaHotel");
		return vagasHotel;
	}
	
	public void adicionar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.salvar(novaVagaHotel);
		novaVagaHotel = new VagaHotel();
		listVagasHotel = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "VagaHotel cadastrada com sucesso!");
	}
	
	public String atualizar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.atualizar(vagaHotelSelecionada);
		vagaHotelSelecionada = new VagaHotel();
		listVagasHotel = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "VagaHotel atualizada com sucesso!");
		return "/vagaHotel/listVagasHotel?faces-redirect=true";
	}
	
	public void apagar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.deletar(vagaHotelSelecionada);
		vagaHotelSelecionada = new VagaHotel();
		listVagasHotel = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "VagaHotel deletada com sucesso!");
	}
	
	
}
