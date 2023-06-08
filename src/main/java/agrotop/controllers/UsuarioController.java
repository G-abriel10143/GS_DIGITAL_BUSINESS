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

import agrotop.domain.produto.DadosAtualizacaoUsuario;
import agrotop.domain.produto.DadosCadastroUsuario;
import agrotop.domain.produto.DadosDetalhamentoUsuario;
import agrotop.domain.produto.Usuario;
import agrotop.repository.UsuarioRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/*
	@PostMapping
	@Transactional
	public ResponseEntity<?> create( @RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder ) {
		var usuario = new Usuario( dados );
		usuarioRepository.save(usuario);
		var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
	}
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
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
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		var usuario = usuarioRepository.getReferenceById(id);
		usuario.excluir();
		return ResponseEntity.noContent().build();
	}
}