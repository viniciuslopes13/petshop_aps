package br.com.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.AnimalDAO;
import br.com.petshop.dao.GenericDAO;
import br.com.petshop.model.Animal;
import br.com.petshop.model.ClienteUser;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class AnimalMBean {

	private Animal novoAnimal;
	private List<Animal> listAnimais;
	private Animal animalSelecionado;
	private ClienteUser dono;
	
	public AnimalMBean() {
		novoAnimal = new Animal();
		animalSelecionado = new Animal();
		listAnimais = this.listar();
		dono = new ClienteUser();
	}
	
	public List<Animal> listar(){
		AnimalDAO animalDAO = new AnimalDAO();
		List<Animal> animais = new ArrayList<Animal>();
		animais = animalDAO.lista();
		return animais;
	}
	
	public void adicionar() {
		/*AnimalDAO animalDAO = new AnimalDAO();
		novoAnimal.setDono(dono);
		animalDAO.salvar(novoAnimal);
		novoAnimal = new Animal();
		listAnimais = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Animal cadastrado com sucesso!");*/
		GenericDAO genericDAO = new GenericDAO();
		novoAnimal.setDono(dono);
		genericDAO.salvar(novoAnimal);
		novoAnimal = new Animal();
		listAnimais = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Animal cadastrado com sucesso!");
	}
	
	public void apagar() {
		AnimalDAO animalDAO = new AnimalDAO();
		animalDAO.deletar(animalSelecionado);
		animalSelecionado = new Animal();
		listAnimais = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Animal deletado com sucesso!");
	}
	
	public String atualizar() {
		AnimalDAO animalDAO = new AnimalDAO();
		animalDAO.atualizar(animalSelecionado);
		animalSelecionado = new Animal();
		listAnimais = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Animal atualizado com sucesso!");
		return "/animal/listAnimais?faces-redirect=true";
	}
}
