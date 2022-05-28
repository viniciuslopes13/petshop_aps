package br.com.petshop.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class ReservaVagaHotel {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "animal_id")
	private Animal hospede;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "vaga_id")
	private VagaHotel vaga;
	
	@Column(name ="dataEntrada" ,columnDefinition = "DATE", nullable = false)
	private LocalDate dataEntrada;
	
	@Column(name ="dataSaida" ,columnDefinition = "DATE", nullable = false)
	private LocalDate dataSaida;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private double valorReserva;

}
