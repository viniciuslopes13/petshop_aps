package br.com.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.GenericDAO;
import br.com.petshop.model.Produto;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class ProdutoMBean {

	private Produto novoProduto;
	private Produto produtoSelecionado;
	private List<Object> listProdutos;
	
	public ProdutoMBean() {
		novoProduto = new Produto();
		produtoSelecionado = new Produto();
		listProdutos = this.listar();
	}
	
	public List<Object> listar(){
		GenericDAO genericDAO = new GenericDAO();
		List<Object> Produtos = new ArrayList<>();
		Produtos = genericDAO.lista("Produto");
		return Produtos;
	}
	
	public void adicionar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.salvar(novoProduto);
		novoProduto = new Produto();
		listProdutos = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Produto cadastrado com sucesso!");
	}
	
	public String atualizar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.atualizar(produtoSelecionado);
		produtoSelecionado = new Produto();
		listProdutos = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Produto atualizado com sucesso!");
		return "/produto/listProdutos?faces-redirect=true";
	}
	
	public void apagar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.deletar(produtoSelecionado);
		produtoSelecionado = new Produto();
		listProdutos = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Produto deletado com sucesso!");
	}
	
}
