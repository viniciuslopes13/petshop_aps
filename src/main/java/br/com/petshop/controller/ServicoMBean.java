package br.com.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.GenericDAO;
import br.com.petshop.model.Servico;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class ServicoMBean {
	
	private Servico novoServico;
	private Servico servicoSelecionado;
	private List<Object> listServicos;
	
	public ServicoMBean() {
		novoServico = new Servico();
		servicoSelecionado = new Servico();
		listServicos = this.listar();
	}
	
	public List<Object> listar(){
		GenericDAO genericDAO = new GenericDAO();
		List<Object> servicos = new ArrayList<>();
		servicos = genericDAO.lista("Servico");
		return servicos;
	}
	
	public void adicionar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.salvar(novoServico);
		novoServico = new Servico();
		listServicos = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Serviço cadastrado com sucesso!");
	}
	
	public String atualizar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.atualizar(servicoSelecionado);
		servicoSelecionado = new Servico();
		listServicos = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Serviço atualizado com sucesso!");
		return "/servico/listServicos?faces-redirect=true";
	}
	
	public void apagar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.deletar(servicoSelecionado);
		servicoSelecionado = new Servico();
		listServicos = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Serviço deletado com sucesso!");
	}

}
