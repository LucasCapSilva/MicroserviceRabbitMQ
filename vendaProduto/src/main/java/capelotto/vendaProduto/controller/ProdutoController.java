package capelotto.vendaProduto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capelotto.vendaProduto.model.Produto;
import capelotto.vendaProduto.repository.ProdutoRepository;
import capelotto.vendaProduto.service.ProdutoService;




@RestController
@CrossOrigin("*")
@RequestMapping("/produto")
public class ProdutoController {
	
	
	@Autowired
	private ProdutoService service;

	@GetMapping("/liberar/{id}")
	public ResponseEntity<Optional<Produto>> GetById(@PathVariable long id){
		return ResponseEntity.ok(service.liberarProduto(id));
	}

}
