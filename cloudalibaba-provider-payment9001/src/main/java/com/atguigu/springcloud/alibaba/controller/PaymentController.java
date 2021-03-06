package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.CommonResult;

/**
 * @auther zzyy
 * @create 2020-02-23 14:13
 */
@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public CommonResult<String> getPayment(@PathVariable("id") Integer id) {
    	return new CommonResult<String>(200, "nacos registry, serverPort = " + serverPort + ", id = " + id);
    }
}
