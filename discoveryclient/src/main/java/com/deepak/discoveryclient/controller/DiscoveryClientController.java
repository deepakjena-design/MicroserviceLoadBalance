package com.deepak.discoveryclient.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
public class DiscoveryClientController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping
	public String getTime() {
		return "The current time "+ new Date().toString()+ " Service running on "+port;
	}
}
