package com.paradigma.pocs.controller;

import com.paradigma.pocs.config.RabbitmqConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    private RabbitTemplate rabbitTemplate;

    public TestController(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public String doSendMessageToRabbitMQ(@RequestBody String message) {
        rabbitTemplate.convertAndSend(RabbitmqConfiguration.QUEUE_NAME, message);
        return "Alive!";
    }

    @RabbitListener(queues = RabbitmqConfiguration.QUEUE_NAME)
    public void onMessageFromRabbitMQ(final String messageFromRabbitMQ){
        log.info("{}", messageFromRabbitMQ);
    }
}
