package agrotop.domain.composteira;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "T_AGROTOP_COMPOSTEIRA")
@Entity(name = "Composteira")
public class Composteira {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Composteira;
	private int quantidade;
	private LocalDateTime data_descarte;
	private String tipo_descarte;
	private String motivo_descarte;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	public Composteira( DadosCadastroComposteira dados ) {
		this.quantidade = dados.quantidade();
		this.data_descarte = dados.data_descarte();
		this.tipo_descarte = dados.tipo_descarte();
		this.motivo_descarte = dados.motivo_descarte();
	}
	
	public void aualizarInformacoes(@Valid DadosAtualizacaoComposteira dados) {
		if( dados.data_descarte() != null )
			this.data_descarte = dados.data_descarte();
		
		if( dados.tipo_descarte() != null )
			this.tipo_descarte = dados.tipo_descarte();
		
		if( dados.motivo_descarte() != null )
			this.motivo_descarte = dados.motivo_descarte();
	}
	
	public Composteira() {
		
	}

	public Composteira(Long id_Composteira, int quantidade, @NotNull LocalDateTime data_descarte,
			@NotBlank String tipo_descarte, @NotBlank String motivo_descarte) {
		super();
		this.id_Composteira = id_Composteira;
		this.quantidade = quantidade;
		this.data_descarte = data_descarte;
		this.tipo_descarte = tipo_descarte;
		this.motivo_descarte = motivo_descarte;
	}

	public Long getId_Composteira() {
		return id_Composteira;
	}

	public void setId_Composteira(Long id_Composteira) {
		this.id_Composteira = id_Composteira;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDateTime getData_descarte() {
		return data_descarte;
	}

	public void setData_descarte(LocalDateTime data_descarte) {
		this.data_descarte = data_descarte;
	}

	public String getTipo_descarte() {
		return tipo_descarte;
	}

	public void setTipo_descarte(String tipo_descarte) {
		this.tipo_descarte = tipo_descarte;
	}

	public String getMotivo_descarte() {
		return motivo_descarte;
	}

	public void setMotivo_descarte(String motivo_descarte) {
		this.motivo_descarte = motivo_descarte;
	}
}
