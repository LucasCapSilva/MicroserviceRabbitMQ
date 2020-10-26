package capelotto.vendaProduto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capelotto.vendaProduto.model.Produto;
import capelotto.vendaProduto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Optional<Produto> liberarProduto(long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		produto.get().setSituação("Liberado");
		produtoRepository.save(produto.get());
		return produto;
		
	}

}
