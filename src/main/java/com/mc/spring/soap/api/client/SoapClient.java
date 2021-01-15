package com.mc.spring.soap.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.mc.spring.soap.api.soapsvc.Acknowledgement;
import com.mc.spring.soap.api.soapsvc.CustomerRequest;

@Service
public class SoapClient {
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate template;

	
	public Acknowledgement getLoanEligibility(CustomerRequest request) {
		template = new WebServiceTemplate(marshaller);
		Acknowledgement acknowledgement = (Acknowledgement) template.marshalSendAndReceive("http://localhost:8080/ws", request);
		return acknowledgement;
	}
}
