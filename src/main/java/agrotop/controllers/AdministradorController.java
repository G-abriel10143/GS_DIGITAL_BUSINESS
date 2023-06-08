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

import agrotop.domain.administrador.Administrador;
import agrotop.domain.administrador.DadosCadastroAdministrador;
import agrotop.domain.administrador.DadosDetalhamentoAdministrador;
import agrotop.repository.AdministradorRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/administrador")
public class AdministradorController {
	@Autowired
	private AdministradorRepository administradorRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> create( @RequestBody @Valid DadosCadastroAdministrador dados, UriComponentsBuilder uriBuilder ) {
		var administrador = new Administrador( dados );
		administradorRepository.save(administrador);
		var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(administrador.getId_administrador()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoAdministrador(administrador));
	}
	
	
	@GetMapping
	public ResponseEntity<List<Administrador>> getAll() {
		return ResponseEntity.ok(administradorRepository.findAll());
	}
	
	/*
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoUsuario> getById( @PathVariable Long id ) {
		var usuario = usuarioRepository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoUsuario> atualizar( @RequestBody @Valid DadosAtualizacaoUsuario dados ) {
		var usuario = usuarioRepository.getReferenceById(dados.id());
		usuario.aualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
	}*/
	
	@DeleteMapping("/{id_administrador}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id_administrador) {
		var administrador = administradorRepository.getReferenceById(id_administrador);
		administrador.excluir();
		return ResponseEntity.noContent().build();
	}
}