package agrotop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agrotop.domain.produto.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
