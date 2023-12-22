package com.gbc8.produto.dados.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbc8.produto.negocio.produto.Produto;

public interface RepositorioJpaProduto extends JpaRepository<Produto, Long>{

}
 