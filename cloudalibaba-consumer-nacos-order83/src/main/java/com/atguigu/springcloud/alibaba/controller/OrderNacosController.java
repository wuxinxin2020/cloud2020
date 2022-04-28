package com.atguigu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.alibaba.service.PaymentFeignService;
import com.atguigu.springcloud.entities.CommonResult;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-23 15:01
 */
@RestController
public class OrderNacosController {
    
    @Resource
    private PaymentFeignService paymentFeignService;

    //@GetMapping(value = "/consumer/payment/nacos/{id}")
    @GetMapping(value = "/consumer/payment/nacos")
    public CommonResult<String> paymentInfo(/*@PathVariable("id")*/ Long id) {
        return paymentFeignService.paymentInfo(id);
    }

}
