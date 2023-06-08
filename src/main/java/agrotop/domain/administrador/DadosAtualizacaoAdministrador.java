package agrotop.domain.administrador;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAdministrador(
		@NotNull
		Long id,
		String nome,
		String telefone
		) {}
