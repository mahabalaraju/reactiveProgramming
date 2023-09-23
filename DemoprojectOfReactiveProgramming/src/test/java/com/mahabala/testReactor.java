package com.mahabala;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class testReactor {

	@Test
	public void teasssf() {
		Mono<String> monoStringMono= Mono.just("raj").log();
		monoStringMono.subscribe(System.out::println);
	}
	
	@Test
	public void eafa() {
		Mono<?> monorefMono= Mono.just("log").log()
				.then(Mono.error(new RuntimeException("Exception occured..,")));
		monorefMono.subscribe(
				e->System.out.println(e),
				(e)->System.out.println("error!!!")
				);
	}
	
	@Test
	public void eadfa() {
		Flux<String> nonaMono= Flux.just("maha", "bala", "raj") 
				.concatWithValues("H")
				.concatWith(Flux.error(new RuntimeException("An Exception occured")))
				.concatWithValues("urs")
				.log();
		nonaMono.subscribe(System.out::print);
	}
	
	
	
	
	
	
	
}
