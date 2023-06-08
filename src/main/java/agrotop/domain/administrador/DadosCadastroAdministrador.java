package agrotop.domain.administrador;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAdministrador( 
			@NotBlank(message = "Nome é obrigatório")
			String nome,
			
			@NotBlank(message = "Email é obrigatório")
			@Email(message = "Formato do email é inválido")
			String email,
			
			@NotBlank(message = "Telefone é obrigatório")
			String telefone,
			
			@NotNull
			LocalDate nascimento,
			Boolean ativo
		) {}
