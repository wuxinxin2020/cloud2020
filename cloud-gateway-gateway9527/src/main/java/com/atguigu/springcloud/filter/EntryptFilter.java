package com.atguigu.springcloud.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.atguigu.springcloud.entity.ApiRegister;
import com.atguigu.springcloud.mapper.ApiRegisterMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class EntryptFilter implements GlobalFilter, Ordered {
	
	@Autowired
	private ApiRegisterMapper apiRegisterMapper;
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest oldRequest = exchange.getRequest();
		String oldPath = oldRequest.getPath().toString();
		log.info("path:{}", oldPath);
		Long apiId = Long.valueOf(oldPath.substring(oldPath.lastIndexOf("/") + 1, oldPath.length()));
		ApiRegister apiRegister = apiRegisterMapper.selectById(apiId);
		if(apiRegister != null) {
			ServerWebExchangeUtils.addOriginalRequestUrl(exchange, oldRequest.getURI());
			//String newPath = "/consumer/payment/nacos/233";
			String newPath = apiRegister.getRequestUri();
			ServerHttpRequest newRequest = oldRequest.mutate()
					.path(newPath)
					.build();
			exchange.getAttributes().put(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
			return chain.filter(exchange.mutate().request(newRequest).build());
		}
		return chain.filter(exchange);
	}
	
	@Override
	public int getOrder() {
		return 0;
	}

}
