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

import agrotop.domain.composteira.Composteira;
import agrotop.domain.composteira.DadosAtualizacaoComposteira;
import agrotop.domain.composteira.DadosCadastroComposteira;
import agrotop.domain.composteira.DadosDetalhamentoComposteira;
import agrotop.repository.ComposteiraRepository;
import jakarta.validation.Valid;

@RequestMapping("/composteira")
@RestController
public class ComposteiraContreller {
	@Autowired ComposteiraRepository composteiraRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar( @RequestBody @Valid DadosCadastroComposteira dados, UriComponentsBuilder uriBuilder ) {
		var composteira = new Composteira(dados);
		composteiraRepository.save(composteira);
		var uri = uriBuilder.path("/composteira/{id}").buildAndExpand(composteira.getId_Composteira()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoComposteira(composteira));
	}
	
	@GetMapping
	public ResponseEntity<List<Composteira>> getAll() {
		return ResponseEntity.ok(composteiraRepository.findAll());
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoComposteira> atualizar( @RequestBody @Valid DadosAtualizacaoComposteira dados ) {
		var composteira = composteiraRepository.getReferenceById(dados.id_composteira());
		composteira.aualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoComposteira(composteira));
	}
	
	@DeleteMapping("/{id_composteira}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id_composteira) {
		composteiraRepository.deleteById(id_composteira);
		return ResponseEntity.noContent().build();
	}
	
}
