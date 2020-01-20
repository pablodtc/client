package com.client.service;

import com.client.model.ClientM;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientS {

	Mono<ClientM> insertClient(ClientM clientM);
	Flux<ClientM> findAllClient();
}
