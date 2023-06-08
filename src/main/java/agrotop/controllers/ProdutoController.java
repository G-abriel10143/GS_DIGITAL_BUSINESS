package agrotop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import agrotop.domain.produto.DadosAtualizacaoProduto;
import agrotop.domain.produto.DadosCadastroProduto;
import agrotop.domain.produto.DadosDetalhamentoProduto;
import agrotop.domain.produto.DadosListagemProduto;
import agrotop.domain.produto.Produto;
import agrotop.repository.ProdutoRepository;
import jakarta.validation.Valid;

@RequestMapping("/produto")
@RestController
public class ProdutoController {
	@Autowired ProdutoRepository produtoRepository;
	

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar( @RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder ) {
		var produto = new Produto(dados);
		produtoRepository.save(produto);
		var uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId_Produto()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemProduto>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		var page = produtoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemProduto::new);
		return	ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id_produto}")
	public ResponseEntity<DadosDetalhamentoProduto> listarPorId(@PathVariable Long id_produto) {
		var produto = produtoRepository.getReferenceById(id_produto);
		return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoProduto> atualizar( @RequestBody @Valid DadosAtualizacaoProduto dados ) {
		var produto = produtoRepository.getReferenceById(dados.id_Produto());
		produto.aualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
	}
	
	@DeleteMapping("/{id_produto}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id_produto) {
		var produto = produtoRepository.getReferenceById(id_produto);
		produto.excluir();
		return ResponseEntity.noContent().build();
	}

}
