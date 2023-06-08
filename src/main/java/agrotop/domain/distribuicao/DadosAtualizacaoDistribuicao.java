package agrotop.domain.distribuicao;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoDistribuicao(
		@NotNull
		Long id_destribuicao,
		int quantidade_distribuida,
		LocalDateTime data_distribuicao,
		Double preco_unitario,
		Double total_vendido
		) {}
