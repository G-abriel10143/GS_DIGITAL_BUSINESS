package agrotop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agrotop.domain.cultivo.Cultivo;

public interface CultivoRepository extends JpaRepository<Cultivo, Long> {

}
