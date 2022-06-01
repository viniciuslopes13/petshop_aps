package br.com.petshop.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@SessionScoped
public class HomeMBean {
	
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
	
	public String agendarServico() {
		return "/servico/agendarServico?faces-redirect=true";
	}
	
	public String verAgendamentos() {
		return "/servico/verAgendamentos?faces-redirect=true";
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
	
	/*ROTAS VACINA*/
	public String novaVacina() {
		return "/vacina/cadastroVacina?faces-redirect=true";
	}
	
	public String listVacinas() {
		return "/vacina/listVacinas?faces-redirect=true";
	}
	
	public String atualizarVacina() {
		return "/vacina/atualizarVacina?faces-redirect=true";
	}
	
	public String vacinarAnimal() {
		return "/vacina/vacinarAnimal?faces-redirect=true";
	}
	
	public String consultaVacinaAnimal() {
		return "/vacina/consultaVacinaAnimal?faces-redirect=true";
	}
	
	public String atualizarCarteiraVacina() {
		return "/vacina/atualizarCarteiraVacina?faces-redirect=true";
	}
	
	/*ROTAS VAGA_HOTEL*/
	public String novaVagaHotel() {
		return "/vagaHotel/cadastroVagaHotel?faces-redirect=true";
	}
	
	public String listVagasHotel() {
		return "/vagaHotel/listVagasHotel?faces-redirect=true";
	}
	
	public String atualizarVagaHotel() {
		return "/vagaHotel/atualizarVagaHotel?faces-redirect=true";
	}
	
	public String cadastrarReservaHotel() {
		return "/vagaHotel/cadastrarReservaHotel?faces-redirect=true";
	}
	
	public String verReservas() {
		return "/vagaHotel/verReservas?faces-redirect=true";
	}
	
}
