package com.gbc8.produto.dados.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gbc8.produto.controlador.exception.NotFoundException;
import com.gbc8.produto.dados.IRepositorio;
import com.gbc8.produto.negocio.produto.Produto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RepositorioProduto implements IRepositorio<Produto>{
	
	@Autowired
	private RepositorioJpaProduto repositorioProduto;

	@Override
	public List<Produto> getAll() {
		return repositorioProduto.findAll();
	}

	@Override
	public Produto getById(Long id) throws NotFoundException {
		try {
			Optional<Produto> produto = repositorioProduto.findById(id);
			if(produto.isEmpty()) {
				throw new NotFoundException("Produto inexistente.");
			}
			return produto.get();
		}catch(NotFoundException error) {
			throw error;
		}catch(Exception error){
			log.error("Erro na busca do produto de id " + id + ":", error.getMessage());
			return null;
		}
	}

	@Override
	public Produto inserir(Produto item) {
		try {
			Produto produto = repositorioProduto.save(item);
			return produto;
		} catch(Exception error) {
			log.error("Erro na insercao de produto:", error.getMessage());
			return null;
		}
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		try {
			if(getById(id) != null) {
				repositorioProduto.deleteById(id);
			}
		}catch(NotFoundException error) {
			throw error;
		}catch(Exception error) {
			log.error("Erro na remocao do produto de id " + id +  ":", error.getMessage());
		}
	}

	@Override
	public Produto atualizar(Produto item) throws NotFoundException {
		try {
			if(getById(item.getId()) != null) {
				Produto produto = repositorioProduto.save(item);
				return produto;
			}
		}catch(NotFoundException error) {
			throw error;
		}catch(Exception error) {
			log.error("Erro na atualizacao do produto de id " + item.getId() + ":", error.getMessage());
			return null;
		}
		return null;
	}
}