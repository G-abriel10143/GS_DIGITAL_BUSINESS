package agrotop.domain.produto;

import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalhamentoUsuario(
		Long id,
		String nome,
		String email,
		String telefone,
		String usuario,
		List<String> idiomas,
		LocalDateTime nascimento
		) {

}