package br.com.petshop.controller;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.GenericDAO;
import br.com.petshop.model.Animal;
import br.com.petshop.model.CarteiraVacina;
import br.com.petshop.model.Vacina;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class CarteiraVacinaMBean {
	
	private CarteiraVacina novaCarteiraVacina;
	private Animal animal;
	private Vacina vacina;
	private CarteiraVacina carteiraSelecionada;
	
	public CarteiraVacinaMBean() {
		novaCarteiraVacina = new CarteiraVacina();
		carteiraSelecionada = new CarteiraVacina();
		animal = new Animal();
		vacina = new Vacina();
	}

	public void adicionar() {
		GenericDAO genericDAO = new GenericDAO();
		novaCarteiraVacina.setAnimal(animal);
		novaCarteiraVacina.setVacina(vacina);
		genericDAO.salvar(novaCarteiraVacina);
		novaCarteiraVacina = new CarteiraVacina();
		animal = new Animal();
		vacina = new Vacina();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Registro de vacina cadastrado com sucesso!");
	}
	
}
