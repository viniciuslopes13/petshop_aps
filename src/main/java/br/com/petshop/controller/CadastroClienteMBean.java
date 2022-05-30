package br.com.petshop.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.petshop.dao.ClienteDAO;
import br.com.petshop.model.ClienteUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class CadastroClienteMBean {

	private ClienteUser cliente;
	
	public CadastroClienteMBean() {
		cliente = new ClienteUser();
	}

	public void salvar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		cliente = new ClienteUser();
		FacesMessage msg = new FacesMessage("Cliente cadastrado com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
	}
	
}
