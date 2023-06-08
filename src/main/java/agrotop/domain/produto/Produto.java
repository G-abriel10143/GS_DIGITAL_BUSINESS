package agrotop.domain.produto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity(name = "Produtos")
@Table(name = "T_AGROTOP_PRODUTOS")

public class Produto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Produto;
	
	@Column(name = "NM_NOME")
	private String nome;
	
	private Categoria categoria;
	
	private LocalDateTime data_validade;
	
	@Column(name = "NR_QUANTIDADE")
	private int quantidade;
	
	private Double preco;
	
	private String fornecedor;
	
	private String descricacao;
	
	private Boolean ativo;
	
	public Produto (DadosCadastroProduto dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.categoria = dados.categoria();
		this.data_validade = dados.data_validade();
		this.quantidade = dados.quantidade();
		this.preco = dados.preco();
		this.fornecedor = dados.fornecedor();
		this.descricacao = dados.descricacao();
	}
	
	public void aualizarInformacoes(@Valid DadosAtualizacaoProduto dados) {
		if( dados.nome() != null )
			this.nome = dados.nome();
		
		if( dados.categoria() != null )
			this.categoria = dados.categoria();
		
		if( dados.quantidade() != 0 )
			this.quantidade = dados.quantidade();
		
		if( dados.preco() != null )
			this.preco = dados.preco();
		
		if( dados.descricacao() != null )
			this.descricacao = dados.descricacao();
	}
	
	public void excluir() {
		this.ativo = false;
	}
	
	public Produto() {
		
	}

	public Produto(Long id_Produto, String nome, Categoria categoria, LocalDateTime data_validade, int quantidade, Double preco,
			String fornecedor, String descricacao, Boolean ativo) {
		super();
		this.id_Produto = id_Produto;
		this.nome = nome;
		this.categoria = categoria;
		this.data_validade = data_validade;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fornecedor = fornecedor;
		this.descricacao = descricacao;
		this.ativo = ativo;
	}

	public Long getId_Produto() {
		return id_Produto;
	}

	public void setId_Produto(Long id_Produto) {
		this.id_Produto = id_Produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LocalDateTime getData_validade() {
		return data_validade;
	}

	public void setData_validade(LocalDateTime data_validade) {
		this.data_validade = data_validade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDescricacao() {
		return descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
