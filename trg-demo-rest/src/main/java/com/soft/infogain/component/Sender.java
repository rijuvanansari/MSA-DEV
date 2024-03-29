package com.soft.infogain.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



@Component 
@Lazy
class Sender {
	
	RabbitMessagingTemplate template;
	
	@Autowired
	Sender(RabbitMessagingTemplate template){
		this.template = template;
	}

	@Bean
	Queue queue() {
		return new Queue("CustomerQ", false);
	}
	
	public void send(String message){
		//template.convertAndSend("CustomerQ", message);
	}
}

