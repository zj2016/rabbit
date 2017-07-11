package com.zj.rabbit.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  zhangjian on 2017/7/5.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/send")
    public String send(String msg) {
        return "success";
    }
}
