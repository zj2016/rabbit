package com.zj.rabbit.api.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by  zhangjian on 2017/7/5.
 */
@Component
public class RabbitService {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "zj:me:queue", durable = "true"),
                    exchange = @Exchange(value = "zj:me:exchange", type = ExchangeTypes.FANOUT, durable = "true")
            )})
    public void re(String msg) {
        System.out.println("接收到 ： " + msg);
    }

}
