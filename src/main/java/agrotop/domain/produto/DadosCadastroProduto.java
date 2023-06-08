package agrotop.domain.produto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
		@NotBlank(message = "Nome é obrigatório")
		String nome,
		
		@NotNull
		LocalDateTime data_validade,
		
		@NotNull(message = "Categoria é obrigatória")
		Categoria categoria,
		
		int quantidade,
		
		@NotNull
		Double preco,
		
		@NotBlank
		String fornecedor,
		
		@NotBlank
		String descricacao
		
	) {}