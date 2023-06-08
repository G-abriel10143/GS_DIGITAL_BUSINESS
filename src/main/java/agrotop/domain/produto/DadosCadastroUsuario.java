package agrotop.domain.produto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroUsuario( 
			Long id,
			
			@NotBlank(message = "Nome é obrigatório")
			String nome,
			
			@NotBlank(message = "Email é obrigatório")
			@Email(message = "Formato do email é inválido")
			String email,
			
			@NotBlank(message = "Telefone é obrigatório")
			String telefone,
			
			@NotBlank(message = "Usuário é obrigatório")
			@Size( max = 30, message = "O usuário só pode conter 30 caracteres" )
			String usuario,
			
			@NotBlank
			List<Idiomas> idiomas,
			
			@NotNull
			LocalDateTime nascimento,
			Boolean ativo
		) {}
