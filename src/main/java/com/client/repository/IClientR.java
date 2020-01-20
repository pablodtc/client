package com.client.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.client.model.ClientM;

import reactor.core.publisher.Mono;

@Repository
public interface IClientR extends ReactiveMongoRepository<ClientM, String>{
	
	Mono<ClientM> findByDocument(String document);

}
