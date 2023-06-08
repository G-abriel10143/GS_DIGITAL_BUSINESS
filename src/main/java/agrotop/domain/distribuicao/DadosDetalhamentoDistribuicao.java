package agrotop.domain.distribuicao;

import java.time.LocalDateTime;


public record DadosDetalhamentoDistribuicao(
		Long id_distribuicao,
		int quantidade_distribuida,
		LocalDateTime data_distribuicao,
		Double preco_unitario,
		Double total_vendido
		) {
	
	public DadosDetalhamentoDistribuicao(Distribuicao distribuicao) {
		this(
				distribuicao.getId_destribuicao(),
				distribuicao.getQuantidade_distribuida(),
				distribuicao.getData_distribuicao(),
				distribuicao.getPreco_unitario(),
				distribuicao.getTotal_vendido());
	}
}
