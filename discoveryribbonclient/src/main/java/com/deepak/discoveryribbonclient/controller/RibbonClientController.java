package com.deepak.discoveryribbonclient.controller;

import javax.inject.Inject;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonClientController {
	
	@Inject
	RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping
	public String getTime() {
		return restTemplate.getForEntity("http://DISCOVERY-CLIENT", String.class).getBody();
	}
}
