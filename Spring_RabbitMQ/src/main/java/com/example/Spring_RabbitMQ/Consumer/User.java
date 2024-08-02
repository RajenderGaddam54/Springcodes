package com.example.Spring_RabbitMQ.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.Spring_RabbitMQ.config.Messagingconfig;
import com.example.Spring_RabbitMQ.dto.Orderstatus;

@Component
public class User {
	
	@RabbitListener(queues = Messagingconfig.QUEUE)
	public void consumeMessageFromQueue(Orderstatus orderstatus) {
		
		
		System.out.println("Message Received from queue"+ orderstatus);
	}

}



