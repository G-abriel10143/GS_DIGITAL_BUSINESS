package agrotop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agrotop.domain.administrador.Administrador;
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
