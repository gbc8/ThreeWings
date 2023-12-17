package com.gbc8.produto.negocio.produto;

import com.gbc8.produto.util.ProdutoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUTO")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "CATEGORIA", nullable = false)
	private String categoria;
	@Column(name = "DESCRICAO")
	private String descricao;
	@Column(name = "QUANTIDADE", nullable = false)
	private Integer quantidade;
	
	public Produto(Long id, ProdutoDTO item) {
		this.id = id;
		this.categoria = item.getCategoria();
		this.nome = item.getNome();
		this.descricao = item.getDescricao();
		this.quantidade = item.getQuantidade();
	}
}
