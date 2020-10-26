package capelotto.crudProduto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import capelotto.crudProduto.repository.ProdutoRepository;
import capelotto.crudProduto.message.ProdutoSendMessage;
import capelotto.crudProduto.model.Produto;

@RestController
@CrossOrigin("*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private  ProdutoRepository repositoty;
	
	@Autowired
	private  ProdutoSendMessage produtoSendMessage;

	
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll(){
		return ResponseEntity.ok(repositoty.findAll());
	}
	
	@PostMapping
	public Produto post (@RequestBody Produto produto){
		repositoty.save(produto);
		produtoSendMessage.sendMessage(produto);
		return produto;
	}

}
