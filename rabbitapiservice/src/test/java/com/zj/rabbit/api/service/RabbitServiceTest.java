package com.zj.rabbit.api.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by  zhangjian on 2017/7/5.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitServiceTest {

    @Autowired
    private RabbitService rabbitService;

    @Test
    public void send() throws Exception {
        rabbitService.send("新短消息");
    }



}