package capelotto.crudProduto.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import capelotto.crudProduto.model.Produto;

@Component
public class ProdutoSendMessage {

	@Value("${crud.rabbitmq.exchange}")
	String exchange;
	
	@Value("${crud.rabbitmq.routingkey}")
	String routingkey;
	
	@Autowired
	public RabbitTemplate rabbitTemplate;

	public void sendMessage(Produto produto) {
		rabbitTemplate.convertAndSend(exchange,routingkey,produto);
	}
	
}
