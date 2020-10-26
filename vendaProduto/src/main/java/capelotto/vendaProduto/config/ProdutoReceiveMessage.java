package capelotto.vendaProduto.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import capelotto.vendaProduto.model.Produto;
import capelotto.vendaProduto.repository.ProdutoRepository;


@Component
public class ProdutoReceiveMessage {

	@Autowired
	private  ProdutoRepository produtoRepository;

	@RabbitListener(queues = {"${crud.rabbitmq.queue}"})
	public void receive (@Payload Produto produto){
		Produto produtoAguardando= new Produto();
		produtoAguardando= produto;
		produtoAguardando.setSituação("aguardando");
		produtoRepository.save(produtoAguardando);
	}
	
}
