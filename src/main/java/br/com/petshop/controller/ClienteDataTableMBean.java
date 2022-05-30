package br.com.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.ClienteDAO;
import br.com.petshop.model.ClienteUser;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class ClienteDataTableMBean {

	private ClienteUser novoCliente;
	private ClienteUser clienteSelecionado;
	private List<ClienteUser> listClientes;
	
	public ClienteDataTableMBean() {
		clienteSelecionado = new ClienteUser();
		novoCliente = new ClienteUser();
		listClientes = this.listar();
	}
	
	public List<ClienteUser> listar(){
		ClienteDAO clienteDAO = new ClienteDAO();
		List<ClienteUser> clientes = new ArrayList<ClienteUser>();
		clientes = clienteDAO.lista();
		return clientes;
	}
	
	public void apagar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.deletar(clienteSelecionado);
		clienteSelecionado = new ClienteUser();
		listClientes = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Cliente deletado com sucesso!");
	}
	
	public void adicionar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(novoCliente);
		novoCliente = new ClienteUser();
		listClientes = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Cliente cadastrado com sucesso!");
	}
	
	public String atualizar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.atualizar(clienteSelecionado);
		clienteSelecionado = new ClienteUser();
		listClientes = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Cliente atualizado com sucesso!");
		return "/cliente/lista?faces-redirect=true";
	}
		
}
