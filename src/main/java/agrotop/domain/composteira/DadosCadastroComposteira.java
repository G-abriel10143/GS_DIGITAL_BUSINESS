package agrotop.domain.composteira;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroComposteira(
		int quantidade,
		
		@NotNull
		Long produto_id,
		
		@NotNull
		LocalDateTime data_descarte,
		
		@NotBlank
		String tipo_descarte,
		
		@NotBlank
		String motivo_descarte
		) {}
