package com.gustavo.springboot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
	
	// Utilizada para ler/consumir a mensagem de uma fila específica
	// O método é inscrito na fila através dessa anoatação.
	// Sempre que uma nova mensagem chegar na fila, ela será consumida por esse método
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void consume(String message) {
		LOGGER.info(String.format("Received message -> %s", message));
	}

}
