package com.mc.spring.soap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mc.spring.soap.api.client.SoapClient;
import com.mc.spring.soap.api.soapsvc.Acknowledgement;
import com.mc.spring.soap.api.soapsvc.CustomerRequest;

@SpringBootApplication
@RestController
public class SoapSpringWsClientApplication {
	
	@Autowired
	private SoapClient client;
	
	
	@PostMapping("/getLoanEligibility")
	public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
		 return client.getLoanEligibility(request);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SoapSpringWsClientApplication.class, args);
	}

}
