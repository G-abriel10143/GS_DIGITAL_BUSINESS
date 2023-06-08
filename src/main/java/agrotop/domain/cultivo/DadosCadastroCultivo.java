package agrotop.domain.cultivo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCultivo(
		@NotBlank
		String nome_planta,
		@NotBlank
		String metodo_cultivo,
		@NotNull
		int tempo_crescimento,
		int dificuldade,
		float temperatura_minima,
		float temperatura_maxima
		) {}
