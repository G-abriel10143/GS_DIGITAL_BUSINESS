package agrotop.domain.distribuicao;

import java.time.LocalDateTime;

import agrotop.domain.produto.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Table(name = "T_AGROTOP_DESTRIBUICAO")
@Entity(name = "Destribuicao")
public class Distribuicao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_destribuicao;
	
	private int quantidade_distribuida;
	
	@NotNull
	private LocalDateTime data_distribuicao;
	
	@NotNull
	private Double preco_unitario;
	
	private Double total_vendido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	public Distribuicao(DadosCadastroDistribuicao dados) {
		this.quantidade_distribuida = dados.quantidade_distribuida();
		this.data_distribuicao = dados.data_distribuicao();
		this.data_distribuicao = dados.data_distribuicao();
		this.preco_unitario = dados.preco_unitario();
	}
	
	public void aualizarInformacoes(@Valid DadosAtualizacaoDistribuicao dados) {
		if( dados.quantidade_distribuida() != 0 )
			this.quantidade_distribuida = dados.quantidade_distribuida();
		
		if( dados.data_distribuicao() != null )
			this.data_distribuicao = dados.data_distribuicao();
		
		if( dados.preco_unitario() != null )
			this.preco_unitario = dados.preco_unitario();
		
		if( dados.total_vendido() != null )
			this.total_vendido = dados.total_vendido();
	}
	
	public Distribuicao() {
		
	}

	public Distribuicao(Long id_destribuicao, Integer quantidade_distribuida, @NotNull LocalDateTime data_distribuicao,
			@NotNull Double preco_unitario, Double total_vendido) {
		super();
		this.id_destribuicao = id_destribuicao;
		this.quantidade_distribuida = quantidade_distribuida;
		this.data_distribuicao = data_distribuicao;
		this.preco_unitario = preco_unitario;
		this.total_vendido = total_vendido;
	}

	public Long getId_destribuicao() {
		return id_destribuicao;
	}

	public void setId_destribuicao(Long id_destribuicao) {
		this.id_destribuicao = id_destribuicao;
	}

	public int getQuantidade_distribuida() {
		return quantidade_distribuida;
	}

	public void setQuantidade_distribuida(int quantidade_distribuida) {
		this.quantidade_distribuida = quantidade_distribuida;
	}

	public LocalDateTime getData_distribuicao() {
		return data_distribuicao;
	}

	public void setData_distribuicao(LocalDateTime data_distribuicao) {
		this.data_distribuicao = data_distribuicao;
	}

	public Double getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public Double getTotal_vendido() {
		return total_vendido;
	}

	public void setTotal_vendido(Double total_vendido) {
		this.total_vendido = total_vendido;
	}
}
