package br.com.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.GenericDAO;
import br.com.petshop.model.Vacina;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class VacinaMBean {

	private Vacina novaVacina;
	private Vacina vacinaSelecionada;
	private List<Object> listVacinas;
	
	public VacinaMBean() {
		novaVacina = new Vacina();
		vacinaSelecionada = new Vacina();
		listVacinas = this.listar();
	}
	
	public List<Object> listar(){
		GenericDAO genericDAO = new GenericDAO();
		List<Object> vacinas = new ArrayList<>();
		vacinas = genericDAO.lista("Vacina");
		return vacinas;
	}
	
	public void adicionar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.salvar(novaVacina);
		novaVacina = new Vacina();
		listVacinas = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Vacina cadastrada com sucesso!");
	}
	
	public String atualizar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.atualizar(vacinaSelecionada);
		vacinaSelecionada = new Vacina();
		listVacinas = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Vacina atualizada com sucesso!");
		return "/Vacina/listVacinas?faces-redirect=true";
	}
	
	public void apagar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.deletar(vacinaSelecionada);
		vacinaSelecionada = new Vacina();
		listVacinas = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Vacina deletada com sucesso!");
	}
	
}
