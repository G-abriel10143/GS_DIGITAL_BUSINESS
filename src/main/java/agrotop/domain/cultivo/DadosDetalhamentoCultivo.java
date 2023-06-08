package agrotop.domain.cultivo;

public record DadosDetalhamentoCultivo(
		Long id_cultivo,
		String nome_planta,
		String metodo_cultivo,
		int tempo_crescimento,
		int dificuldade,
		float temperatura_minima,
		float temperatura_maxima
		) {
	
	public DadosDetalhamentoCultivo(Cultivo cultivo) {
		this(
				cultivo.getId_cultivo(),
				cultivo.getNome_planta(),
				cultivo.getMetodo_cultivo(),
				cultivo.getTempo_crescimento(),
				cultivo.getDificuldade(),
				cultivo.getTemperatura_minima(),
				cultivo.getTemperatura_maxima());
	}
}
