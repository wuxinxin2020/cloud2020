package com.atguigu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @auther zzyy
 * @create 2020-02-19 23:59
 */
@Component
@FeignClient(value = "nacos-payment-provider", fallbackFactory = PaymentFeignFallbackService.class)
public interface PaymentFeignService {

	@GetMapping(value = "/payment/nacos/{id}")
	public CommonResult<String> paymentInfo(@PathVariable("id") Long id);
	
}