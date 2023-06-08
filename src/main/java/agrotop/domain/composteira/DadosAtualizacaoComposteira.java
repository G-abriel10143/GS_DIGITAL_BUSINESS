package agrotop.domain.composteira;

import java.time.LocalDateTime;

public record DadosAtualizacaoComposteira(
		Long id_composteira,
		LocalDateTime data_descarte,
		String tipo_descarte,
		String motivo_descarte
		) {}
