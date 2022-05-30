package br.com.petshop.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.model.ClienteUser;
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
	
	public String home() {
		return "/index?faces-redirect=true";
	}
	
	/*ROTAS CLIENTES*/
	public String novoCliente() {
		return "/cliente/cadastro?faces-redirect=true";
	}
	
	public String listClientes() {
		return "/cliente/lista?faces-redirect=true";
	}
		
	public String atualizarCliente() {
		return "/cliente/atualizar?faces-redirect=true";
	}
	
	/*ROTAS ANIMAIS*/
	public String novoAnimal() {
		return "/animal/cadastroAnimal?faces-redirect=true";
	}
	
	public String listAnimais() {
		return "/animal/listAnimais?faces-redirect=true";
	}
	
	public String atualizarAnimal() {
		return "/animal/atualizarAnimal?faces-redirect=true";
	}
	
	/*ROTAS SERVIÇOS*/
	public String novoServico() {
		return "/servico/cadastroServico?faces-redirect=true";
	}
	
	public String listServicos() {
		return "/servico/listServicos?faces-redirect=true";
	}
	
	public String atualizarServico() {
		return "/servico/atualizarServico?faces-redirect=true";
	}
	
	/*ROTAS PRODUTOS*/
	public String novoProduto() {
		return "/produto/cadastroProduto?faces-redirect=true";
	}
	
	public String listProdutos() {
		return "/produto/listProdutos?faces-redirect=true";
	}
	
	public String atualizarProduto() {
		return "/produto/atualizarProduto?faces-redirect=true";
	}
	
}