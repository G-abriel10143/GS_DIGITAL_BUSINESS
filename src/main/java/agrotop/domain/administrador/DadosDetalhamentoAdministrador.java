package agrotop.domain.administrador;

import java.time.LocalDate;

public record DadosDetalhamentoAdministrador(
		Long id,
		String nome,
		String email,
		String telefone,
		LocalDate nascimento
		) {
	
	public DadosDetalhamentoAdministrador(Administrador administrador) {
		this(
				administrador.getId_administrador(),
				administrador.getNome(),
				administrador.getEmail(),
				administrador.getTelefone(),
				administrador.getNascimento());
	}

}