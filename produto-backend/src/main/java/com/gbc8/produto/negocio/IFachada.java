package com.gbc8.produto.negocio;

import java.util.List;

import com.gbc8.produto.controlador.exception.NotFoundException;
import com.gbc8.produto.negocio.produto.Produto;
import com.gbc8.produto.util.ProdutoDTO;

public interface IFachada {
	public List<Produto> getAll();
	public Produto getById(Long id) throws NotFoundException;
	public Produto inserir(ProdutoDTO item);
	public void delete(Long id) throws NotFoundException;
	public Produto atualizar(ProdutoDTO item, Long id) throws NotFoundException;
}
