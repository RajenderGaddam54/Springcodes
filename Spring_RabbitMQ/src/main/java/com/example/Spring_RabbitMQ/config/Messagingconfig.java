package com.example.Spring_RabbitMQ.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.GenericArgumentsConfigurer;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Messagingconfig {

	
	public static final String QUEUE = "chintu_queue";
	public static final String EXCHANGE = "chintu_exchange";
	public static final String ROUTING_KEY="chintu_key";
	
	
	@Bean
	public GenericArgumentsConfigurer binding (Queue QUEUE,Exchange EXCHANGE) {
		
		return BindingBuilder.bind(QUEUE).to(EXCHANGE).with(ROUTING_KEY);
	}
	
	@Bean
	public MessageConverter convertor() {
		
		return new Jackson2JsonMessageConverter();
	}
	
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionfactory) {
		
		final RabbitTemplate rabbittemplate = new RabbitTemplate(connectionfactory)
		rabbittemplate.setMessageConverter(convertor());
		return rabbittemplate ;
		
		
	}
}
