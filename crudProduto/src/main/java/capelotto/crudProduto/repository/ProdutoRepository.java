package capelotto.crudProduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import capelotto.crudProduto.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
