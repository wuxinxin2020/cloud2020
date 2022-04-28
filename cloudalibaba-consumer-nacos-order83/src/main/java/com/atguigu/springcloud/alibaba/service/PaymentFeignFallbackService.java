package com.atguigu.springcloud.alibaba.service;

import org.springframework.stereotype.Component;
import com.atguigu.springcloud.entities.CommonResult;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther zzyy
 * @create 2020-02-19 23:59
 */
@Component
@Slf4j
public class PaymentFeignFallbackService implements FallbackFactory<PaymentFeignService> {

	@Override
	public PaymentFeignService create(Throwable arg0) {
		log.error("异常", arg0);
		return new PaymentFeignService() {

			@Override
			public CommonResult<String> paymentInfo(Long id) {
				return new CommonResult<String>(500, "支付服务异常");
			}
		};
	}
	
}