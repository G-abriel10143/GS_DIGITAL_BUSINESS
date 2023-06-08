package agrotop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agrotop.domain.distribuicao.Distribuicao;

public interface DistribuicaoRepository extends JpaRepository<Distribuicao, Long> {

}
