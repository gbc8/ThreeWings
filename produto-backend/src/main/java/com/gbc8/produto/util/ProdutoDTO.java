package com.gbc8.produto.util;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
	@NotBlank(message = "O campo nome deve ser diferente dos valores: null e vazio.")
	private String nome;
	@NotBlank(message = "O campo categoria deve ser diferente dos valores: null e vazio.")
	private String categoria;
	private String descricao;
	@NotNull(message = "O campo quantidade deve ser diferente de null.")
	@PositiveOrZero(message = "O campo quantidade deve ser maior ou igual a 0.")
	private Integer quantidade;
}