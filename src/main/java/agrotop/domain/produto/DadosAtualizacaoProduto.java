package agrotop.domain.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
			@NotNull
			Long id_Produto,
			String nome,
			Categoria categoria,
			int quantidade,
			Double preco,
			String descricacao
		) {}
