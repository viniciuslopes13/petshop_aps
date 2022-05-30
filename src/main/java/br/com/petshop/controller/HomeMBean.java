package br.com.petshop.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.petshop.dao.ClienteDAO;
import br.com.petshop.model.ClienteUser;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class HomeMBean {

	private ClienteUser cliente;
	
	public HomeMBean() {
		cliente = new ClienteUser();
	}
	
	public String novoCliente() {
		return "/cliente/cadastro?faces-redirect=true";
	}
	
	public String listClientes() {
		return "/cliente/lista?faces-redirect=true";
	}
	
	public String home() {
		return "/index?faces-redirect=true";
	}
	
	public String atualizarCliente() {
		return "/cliente/atualizar?faces-redirect=true";
	}
	
}
