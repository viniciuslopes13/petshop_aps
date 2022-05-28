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
public class CarteiraVacina {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "animal_id")
	private Animal animal;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "vacina_id")
	private Vacina vacina;
	
	@Column(name ="dataVacina" ,columnDefinition = "DATE", nullable = false)
	private LocalDate dataVacina;
	
	@Column(length = 200, nullable = false)
	private String informacoes;
	
}
