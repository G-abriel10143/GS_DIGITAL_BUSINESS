package agrotop.domain.distribuicao;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroDistribuicao(
		int quantidade_distribuida,
		@NotNull
		LocalDateTime data_distribuicao,
		@NotNull
		Double preco_unitario,
		int total_vendido
		) {}
