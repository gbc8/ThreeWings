package com.gbc8.produto.util;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
	@Size(max = 50, message = "O campo nome deve possuir 50 caracteres ou menos.")
	@NotBlank(message = "O campo nome deve ser diferente dos valores: null e vazio.")
	private String nome;
	@Size(max = 50, message = "O campo categoria deve possuir 50 caracteres ou menos.")
	@NotBlank(message = "O campo categoria deve ser diferente dos valores: null e vazio.")
	private String categoria;
	@Size(max = 250, message = "O campo descricao deve possuir 250 caracteres ou menos.")
	private String descricao;
	@NotNull(message = "O campo quantidade deve ser diferente de null.")
	@PositiveOrZero(message = "O campo quantidade deve ser maior ou igual a 0.")
	private Integer quantidade;
}