package agrotop.domain.administrador;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity(name = "administrador")
@Table(name = "T_AGROTOP_ADIMISTRADOR")
public class Administrador {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_administrador;
	
	@Column(name = "NM_NOME")
	private String nome;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "NR_TELEFONE")
	private String telefone;
	
	@Column(name = "DT_NASCIMENTO")
	private LocalDate nascimento;
	
	@Column(name = "ATIVO")
	private Boolean ativo;
	
	public Administrador() {
		
	}
	public Administrador(Long id_administrador, String nome, String email, String telefone, LocalDate nascimento,
			Boolean ativo) {
		super();
		this.id_administrador = id_administrador;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.ativo = ativo;
	}

	public Administrador (DadosCadastroAdministrador dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.nascimento = dados.nascimento();
	}
	
	public void aualizarInformacoes(@Valid DadosAtualizacaoAdministrador dados) {
		if( dados.nome() != null )
			this.nome = dados.nome();
		if( dados.telefone() != null )
			this.telefone = dados.telefone();
	}
	
	public void excluir() {
		this.ativo = false;
	}
	public Long getId_administrador() {
		return id_administrador;
	}
	public void setId_administrador(Long id_administrador) {
		this.id_administrador = id_administrador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
