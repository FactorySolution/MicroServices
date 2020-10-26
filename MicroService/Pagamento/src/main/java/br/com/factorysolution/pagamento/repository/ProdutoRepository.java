package br.com.factorysolution.pagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.factorysolution.pagamento.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
