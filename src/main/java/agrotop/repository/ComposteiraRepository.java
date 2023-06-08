package agrotop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import agrotop.domain.composteira.Composteira;

public interface ComposteiraRepository extends JpaRepository<Composteira, Long> {
	Page<Composteira> findAllBy(Pageable paginacao);
}
