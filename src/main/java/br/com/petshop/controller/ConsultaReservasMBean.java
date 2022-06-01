package br.com.petshop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.GenericDAO;
import br.com.petshop.dao.VagaHotelDAO;
import br.com.petshop.model.CarteiraVacina;
import br.com.petshop.model.ReservaVagaHotel;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class ConsultaReservasMBean {

	private Date dataBusca;
	private ReservaVagaHotel reservaSelecionada;
	private List<ReservaVagaHotel> reservas;
	
	public ConsultaReservasMBean() {
		dataBusca = new Date();
		reservaSelecionada = new ReservaVagaHotel();
		reservas = new ArrayList<ReservaVagaHotel>();
	}
	
	public void listar() {
		VagaHotelDAO vagaHotelDAO = new VagaHotelDAO();
		this.reservas = vagaHotelDAO.findByData(dataBusca);
	}
	
	public void apagar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.deletar(reservaSelecionada);
		reservaSelecionada = new ReservaVagaHotel();
		this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Reserva deletada com sucesso!");
	}
	
}
