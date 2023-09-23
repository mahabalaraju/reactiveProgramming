package com.mahabala.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mahabala.Dao.ModelDao;
import com.mahabala.model.model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class modelhandler {

	@Autowired
	private ModelDao dao;
	
	public Mono<ServerResponse> getallconsumers(ServerRequest request){
		Flux<model> getallFlux= dao.getallmodelObjects();
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(getallFlux,model.class);
	}
	
}
