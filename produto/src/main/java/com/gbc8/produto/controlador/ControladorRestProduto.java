package com.gbc8.produto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbc8.produto.controlador.exception.NotFoundException;
import com.gbc8.produto.negocio.IFachada;
import com.gbc8.produto.negocio.produto.Produto;
import com.gbc8.produto.util.ProdutoDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produto")
public class ControladorRestProduto {
	
	private IFachada fachada;
	
	@Autowired
	public ControladorRestProduto(IFachada fachada) {
		this.fachada = fachada;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok().body(fachada.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) throws NotFoundException {
		return ResponseEntity.ok().body(fachada.getById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<Produto> inserirProduto(@RequestBody @Valid ProdutoDTO produto){
		return ResponseEntity.ok().body(fachada.inserir(produto));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Produto> atualizarProduto(@RequestBody @Valid ProdutoDTO produtoDTO, @PathVariable Long id) throws NotFoundException{
		return ResponseEntity.ok().body(fachada.atualizar(produtoDTO, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) throws NotFoundException{
		fachada.delete(id);
		return ResponseEntity.noContent().build();
	}

}