package com.mahabala.controller;

import java.time.Duration;
import java.util.List;

import javax.lang.model.element.ModuleElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahabala.model.model;
import com.mahabala.modelService.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {

	@Autowired
	private service service;
	
	@GetMapping("/hi")
	public Mono<String> getdetails() {
		return avin().zipWith(raj()).map(
        value-> value.getT1()+value.getT1()
		);
	}

	private Mono<String> avin() {
		return Mono.just("avin").delayElement(Duration.ofSeconds(5));
	}
	

	private Mono<String> raj() {
		return Mono.just("sangamesh").delayElement(Duration.ofSeconds(5));
	}
	
//	@GetMapping("/modelObjects")
//	public  List<model>  getall(){
//		return service.loadAllModelObjects();
//	}
	
	
	@GetMapping(value="/modelObjects",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public  Flux<model>  getall(){
		return service.loadAllModelObjects();
	}
}
