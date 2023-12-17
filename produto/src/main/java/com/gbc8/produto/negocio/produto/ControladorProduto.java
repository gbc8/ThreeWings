package com.gbc8.produto.negocio.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gbc8.produto.controlador.exception.NotFoundException;
import com.gbc8.produto.dados.IRepositorio;

@Component
public class ControladorProduto {
	
	private IRepositorio<Produto> repositorioProduto;
	
	@Autowired
	public ControladorProduto(IRepositorio<Produto> repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}

	public List<Produto> getAll() {
		List<Produto> produtos = repositorioProduto.getAll();
		return produtos;
	}
	
	public Produto getById(Long id) throws NotFoundException {
		Produto produto = (Produto) repositorioProduto.getById(id);
		return produto;
	}

	public Produto inserir(Produto produto) {
		Produto novoProduto = (Produto) repositorioProduto.inserir(produto);
		return novoProduto;
	}

	public void delete(Long id) throws NotFoundException {
		repositorioProduto.delete(id);
	}

	public Produto atualizar(Produto produto) throws NotFoundException {
		Produto novoProduto = (Produto) repositorioProduto.atualizar(produto);
		return novoProduto;
	}
}
