package com.gbc8.produto.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gbc8.produto.controlador.exception.NotFoundException;
import com.gbc8.produto.negocio.produto.ControladorProduto;
import com.gbc8.produto.negocio.produto.Produto;
import com.gbc8.produto.util.ProdutoDTO;

@Component
public class Fachada implements IFachada {
	
	private ControladorProduto controladorProduto;
	
	@Autowired
	public Fachada(ControladorProduto controladorProduto) {
		this.controladorProduto = controladorProduto;
	}

	@Override
	public List<Produto> getAll() {
		List<Produto> produtos = controladorProduto.getAll();
		return produtos;
	}

	@Override
	public Produto getById(Long id) throws NotFoundException {
		Produto produto = (Produto) controladorProduto.getById(id);
		return produto;
	}

	@Override
	public Produto inserir(ProdutoDTO item) {
		Produto novoProduto = new Produto(null, item);
		Produto produto = (Produto) controladorProduto.inserir(novoProduto);
		return produto;
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		controladorProduto.delete(id);
	}

	@Override
	public Produto atualizar(ProdutoDTO item, Long id) throws NotFoundException {
		Produto novoProduto = new Produto(id, item);
		Produto produto = (Produto) controladorProduto.atualizar(novoProduto);
		return produto;
	}

}
