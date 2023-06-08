package agrotop.domain.cultivo;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCultivo(
			@NotNull
			Long id_cultivo,
			String metodo_cultivo,
			int tempo_crescimento,
			int dificuldade
		) {}
