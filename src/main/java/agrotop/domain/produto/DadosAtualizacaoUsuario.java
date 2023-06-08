package agrotop.domain.produto;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
		@NotNull
		Long id,
		String nome,
		String telefone
		) {}
