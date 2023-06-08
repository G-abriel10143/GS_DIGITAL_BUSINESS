package agrotop.domain.composteira;

import java.time.LocalDateTime;

public record DadosListagemComposteira(
		Long id_Composteira,
		int quantidade,
		LocalDateTime data_descarte,
		String tipo_descarte,
		String motivo_descarte
		) {
	
	public DadosListagemComposteira(Composteira composteira) {
		this(
				composteira.getId_Composteira(),
				composteira.getQuantidade(),
				composteira.getData_descarte(),
				composteira.getTipo_descarte(),
				composteira.getMotivo_descarte());
	}

}
