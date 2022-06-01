package br.com.petshop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.GenericDAO;
import br.com.petshop.dao.VagaHotelDAO;
import br.com.petshop.model.Animal;
import br.com.petshop.model.CarteiraVacina;
import br.com.petshop.model.ReservaVagaHotel;
import br.com.petshop.model.Vacina;
import br.com.petshop.model.VagaHotel;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class CadastrarReservaHotelMBean {

	private ReservaVagaHotel reservaVagaHotel;
	private Animal animal;
	private VagaHotel vagaHotel;
	private Double valorReserva;
	
	public CadastrarReservaHotelMBean() {
		reservaVagaHotel = new ReservaVagaHotel();
		animal = new Animal();
		vagaHotel = new VagaHotel();
	}
	
	public void calcularValorDiaria() {
		VagaHotelDAO vagaHotelDAO = new VagaHotelDAO();
		int id = vagaHotel.getId();
		this.setVagaHotel(vagaHotelDAO.findById(id));
		reservaVagaHotel.setVaga(vagaHotel);
		int diferenca = reservaVagaHotel.getDataSaida().getDay() - reservaVagaHotel.getDataEntrada().getDay();
		if(diferenca<1) {
			diferenca=1;
		}
		valorReserva = vagaHotel.getValorDiaria()*diferenca;
		this.reservaVagaHotel.setValorReserva(valorReserva);
	}
	
	public void adicionar() {
		GenericDAO genericDAO = new GenericDAO();
		reservaVagaHotel.setHospede(animal);
		reservaVagaHotel.setVaga(vagaHotel);
		genericDAO.salvar(reservaVagaHotel);
		reservaVagaHotel = new ReservaVagaHotel();
		animal = new Animal();
		vagaHotel = new VagaHotel();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Reserva cadastrada com sucesso!");
	}
	
}
