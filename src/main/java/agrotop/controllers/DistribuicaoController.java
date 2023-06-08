package agrotop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import agrotop.domain.distribuicao.DadosAtualizacaoDistribuicao;
import agrotop.domain.distribuicao.DadosCadastroDistribuicao;
import agrotop.domain.distribuicao.DadosDetalhamentoDistribuicao;
import agrotop.domain.distribuicao.Distribuicao;
import agrotop.repository.DistribuicaoRepository;
import jakarta.validation.Valid;

@RequestMapping("/distribuicao")
@RestController
public class DistribuicaoController {
	@Autowired DistribuicaoRepository distribuicaoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar( @RequestBody @Valid DadosCadastroDistribuicao dados, UriComponentsBuilder uriBuilder ) {
		var distribuicao = new Distribuicao(dados);
		distribuicaoRepository.save(distribuicao);
		var uri = uriBuilder.path("/distribuicao/{id}").buildAndExpand(distribuicao.getId_destribuicao()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoDistribuicao(distribuicao));
	}
	
	@GetMapping
	public ResponseEntity<List<Distribuicao>> getAll() {
		return ResponseEntity.ok(distribuicaoRepository.findAll());
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoDistribuicao> atualizar( @RequestBody @Valid DadosAtualizacaoDistribuicao dados ) {
		var distribuicao = distribuicaoRepository.getReferenceById(dados.id_destribuicao());
		distribuicao.aualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoDistribuicao(distribuicao));
	}
	
	@DeleteMapping("/{id_distribuicao}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id_composteira) {
		distribuicaoRepository.deleteById(id_composteira);
		return ResponseEntity.noContent().build();
	}

}
