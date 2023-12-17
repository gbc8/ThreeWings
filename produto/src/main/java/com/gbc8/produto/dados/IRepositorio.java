package com.gbc8.produto.dados;

import java.util.List;

import com.gbc8.produto.controlador.exception.NotFoundException;

public interface IRepositorio<T> {
	
	public List<T> getAll();
	public T getById(Long id) throws NotFoundException;
	public T inserir(T item);
	public void delete(Long id) throws NotFoundException;
	public T atualizar(T item) throws NotFoundException;
	
}
