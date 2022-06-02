package br.com.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.petshop.dao.GenericDAO;
import br.com.petshop.dao.ServicoDAO;
import br.com.petshop.model.Agendamento;
import br.com.petshop.model.Servico;
import br.com.petshop.model.ClienteUser;
import br.com.petshop.util.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class AgendamentoMBean {

	private Agendamento agendamento;
	private ClienteUser cliente;
	private Servico servico;
	private List<Object> agendamentos;
	private Agendamento agendamentoSelecionado;
	
	public AgendamentoMBean() {
		agendamento = new Agendamento();
		cliente = new ClienteUser();
		servico = new Servico();
		agendamentos = this.listar();
		agendamentoSelecionado = new Agendamento();
	}
	
	public List<Object> listar(){
		GenericDAO genericDAO = new GenericDAO();
		List<Object> agendamentos = new ArrayList<Object>();
		agendamentos = genericDAO.lista("Agendamento");
		return agendamentos;
	}
	
	public void atualizarValor() {
		ServicoDAO servicoDAO = new ServicoDAO();
		Servico serv = servicoDAO.findById(servico.getId());
		this.agendamento.setPrecoTotal(serv.getPreco());
	}
	
	public void adicionar() {
		GenericDAO genericDAO = new GenericDAO();
		agendamento.setCliente(cliente);
		agendamento.setServico(servico);
		genericDAO.salvar(agendamento);
		agendamento = new Agendamento();
		servico = new Servico();
		cliente = new ClienteUser();
		agendamentos = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Agendamento cadastrado com sucesso!");
	}
	
	public void apagar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.deletar(agendamentoSelecionado);
		agendamentoSelecionado = new Agendamento();
		agendamentos = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Agendamento deletado com sucesso!");
	}
	
	public String atualizar() {
		GenericDAO genericDAO = new GenericDAO();
		genericDAO.atualizar(agendamentoSelecionado);
		agendamentoSelecionado = new Agendamento();
		agendamentos = this.listar();
		Mensagem.exibir(FacesMessage.SEVERITY_INFO, "Agendamento atualizado com sucesso!");
		return "/servico/verAgendamentos?faces-redirect=true";
	}
}
