package agrotop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import agrotop.domain.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Page<Produto> findAllByAtivoTrue(Pageable paginacao);
}
