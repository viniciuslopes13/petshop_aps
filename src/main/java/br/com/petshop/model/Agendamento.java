package br.com.petshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Agendamento {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private ClienteUser cliente;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataAgendada", nullable = false)
	private Date dataAgendada;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "servico_id")
	private Servico servico;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private double precoTotal;
	
	@Column(length = 200, nullable = false)
	private String informacoes;
	
	
}
