package agrotop.domain.recompensa;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "T_AGROTOP_RECOMPENSA")
@Entity(name = "Recompensa")
public class Recompensa {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_recompensa;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private Integer pontos;
	
	private LocalDateTime data_expiracao;

	public Recompensa() {
		
	}
	
	public Recompensa(Long id_recompensa, @NotBlank String nome, @NotBlank String descricao, @NotNull Integer pontos,
			LocalDateTime data_expiracao) {
		super();
		this.id_recompensa = id_recompensa;
		this.nome = nome;
		this.descricao = descricao;
		this.pontos = pontos;
		this.data_expiracao = data_expiracao;
	}

	public Long getId_recompensa() {
		return id_recompensa;
	}

	public void setId_recompensa(Long id_recompensa) {
		this.id_recompensa = id_recompensa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public LocalDateTime getData_expiracao() {
		return data_expiracao;
	}

	public void setData_expiracao(LocalDateTime data_expiracao) {
		this.data_expiracao = data_expiracao;
	}
}
