package com.mahabala.handler;

import java.security.PublicKey;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mahabala.Dao.ModelDao;
import com.mahabala.model.model;

import ch.qos.logback.core.model.Model;
import ch.qos.logback.core.model.ModelConstants;
import lombok.experimental.var;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

	@Autowired
	private ModelDao dao;

	public Mono<ServerResponse> getcustomers(ServerRequest request) {
		Flux<model> d = dao.getall();
		return ServerResponse.ok().body(d, Model.class);
	}

	public Mono<ServerResponse> findcustomers(ServerRequest request) {
		int id = Integer.valueOf(request.pathVariable("input"));
		Mono<model> custMono = dao.getallmodelObjects().filter(e -> e.getId() == id).take(1).single();
		// dao.getall().filter(e->e.getId()==id).next();
		return ServerResponse.ok().body(custMono, model.class);
	}

	public Mono<ServerResponse> savecuMono(ServerRequest request){
		Mono<model> saveMono= request.bodyToMono(model.class);
	Mono<String> getMono=	saveMono.map(dto->dto.getId()+":"+dto.getName());
		return ServerResponse.ok().body(getMono, String.class);
	}
}














