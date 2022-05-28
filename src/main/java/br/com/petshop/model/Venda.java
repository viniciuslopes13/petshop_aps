package br.com.petshop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Venda {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private ClienteUser cliente;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="venda_produto", 
				joinColumns = {@JoinColumn(name="venda_id")},
				inverseJoinColumns = {@JoinColumn(name="produto_id")})
	private List<Produto> produtos;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private double valorVenda;
	
}
