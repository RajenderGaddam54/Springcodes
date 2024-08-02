package com.example.Spring_RabbitMQ.Publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring_RabbitMQ.config.Messagingconfig;
import com.example.Spring_RabbitMQ.dto.Orderstatus;

@RestController
@RequestMapping("/order")
public class Orderpublisher {
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/{restaurantname}")
	public String bookorder(@RequestBody Order order, @PathVariable String restaurantname) {
		
		order.setorderid(UUID.randomUUID().toString());
		
		Orderstatus orderstatus = new Orderstatus(order,"Process","order placed successfully in "+restaurantname);
		
		template.convertAndSend(Messagingconfig.EXCHANGE, Messagingconfig.ROUTING_KEY, orderstatus);
		return "SUCCESS !!";
		
	}

}
