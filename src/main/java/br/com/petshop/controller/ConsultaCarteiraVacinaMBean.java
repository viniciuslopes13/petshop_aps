package br.com.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.CarteiraVacinaDAO;
import br.com.petshop.dao.GenericDAO;
import br.com.petshop.model.Animal;
import br.com.petshop.model.CarteiraVacina;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class ConsultaCarteiraVacinaMBean {

	private Animal animal;
	private List<CarteiraVacina> vacinas;
	private CarteiraVacina carteiraSelecionada;
	
	public ConsultaCarteiraVacinaMBean() {
		animal = new Animal();
		carteiraSelecionada = new CarteiraVacina();
		vacinas = new ArrayList<CarteiraVacina>();
	}
	
	public void listar() {
		CarteiraVacinaDAO carteiraVacinaDAO = new CarteiraVacinaDAO();
		this.vacinas = carteiraVacinaDAO.findByAnimal(animal);
	}
	
	public String atualizar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.atualizar(carteiraSelecionada);
		carteiraSelecionada = new CarteiraVacina();
		this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "CarteiraVacina atualizada com sucesso!");
		return "/vacina/consultaVacinaAnimal?faces-redirect=true";
	}
	
	public void apagar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.deletar(carteiraSelecionada);
		carteiraSelecionada = new CarteiraVacina();
		this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "CarteiraVacina deletada com sucesso!");
	}
		
}
