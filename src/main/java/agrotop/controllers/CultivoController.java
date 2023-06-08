package agrotop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import agrotop.domain.cultivo.Cultivo;
import agrotop.domain.cultivo.DadosCadastroCultivo;
import agrotop.domain.cultivo.DadosDetalhamentoCultivo;
import agrotop.repository.CultivoRepository;
import jakarta.validation.Valid;

@RequestMapping("/cultivo")
@RestController
public class CultivoController {
	@Autowired CultivoRepository cultivoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar( @RequestBody @Valid DadosCadastroCultivo dados, UriComponentsBuilder uriBuilder ) {
		var cultivo = new Cultivo(dados);
		cultivoRepository.save(cultivo);
		var uri = uriBuilder.path("/cultivo/{id}").buildAndExpand(cultivo.getId_cultivo()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoCultivo(cultivo));
	}
	
	@GetMapping
	public ResponseEntity<List<Cultivo>> getAll() {
		return ResponseEntity.ok(cultivoRepository.findAll());
	}
	
	@GetMapping("/{id_cultivo}")
	public ResponseEntity<DadosDetalhamentoCultivo> listarPorId(@PathVariable Long id_cultivo) {
		var cultivo = cultivoRepository.getReferenceById(id_cultivo);
		return ResponseEntity.ok(new DadosDetalhamentoCultivo(cultivo));
	}
	
	@DeleteMapping("/{id_cultivo}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id_cultivo) {
		cultivoRepository.deleteById(id_cultivo);
		return ResponseEntity.noContent().build();
	}
}
