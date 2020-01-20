package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.model.ClientM;
import com.client.service.ClientS;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientC {
	
	@Autowired
	ClientS clientS;
	
	@PostMapping("/insert")
	Mono<ClientM> insertClient(@RequestBody ClientM clientM){
		
		return clientS.insertClient(clientM);
		
	}
	
	@GetMapping("/find-all-client")
	Flux<ClientM> findAllClient(){
		
		return clientS.findAllClient();
		
	}
	
	@GetMapping("/find-by-document/{document}")
	Mono<ClientM> findByDocument(@PathVariable String document){
		
		return clientS.findByDocument(document);
		
	}

}
