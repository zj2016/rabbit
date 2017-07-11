package com.zj.rabbit.api.service;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.http.client.domain.ExchangeType;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by  zhangjian on 2017/7/5.
 */
@Service
public class RabbitService {

    private static final String exChange = "zj:me:exchange";

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    public void send(String msg) {
        rabbitTemplate.convertAndSend(exChange, "", msg);
    }

    @PostConstruct
    public void init() {
        System.out.println("---------------------------------init------------------------");
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "zj:me:queue", durable = "true"),
                    exchange = @Exchange(value = "zj:me:exchange", type = ExchangeTypes.FANOUT, durable = "true")
            )})
    public void re(String msg) {
        System.out.println("接收到 ： " + msg);
    }

}
