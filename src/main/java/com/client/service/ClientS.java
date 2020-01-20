package com.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.model.ClientM;
import com.client.repository.IClientR;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientS implements IClientS{
	
	@Autowired
	IClientR iClientR;
	
	@Override
	public Mono<ClientM> insertClient(ClientM clientM) {
		
		return findByDocument(clientM.getDocument())
			.flatMap(a -> {
				return Mono.just(clientM);
			}).switchIfEmpty(iClientR.save(clientM).flatMap(b -> {
				return Mono.just(clientM);
			}));
	}

	@Override
	public Flux<ClientM> findAllClient() {
		
		return iClientR.findAll();
	}
	
	public Mono<ClientM> findByDocument(String document){
		
		return iClientR.findByDocument(document);
	}

}