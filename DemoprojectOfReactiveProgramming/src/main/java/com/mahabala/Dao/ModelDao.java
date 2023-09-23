package com.mahabala.Dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.core.env.AbstractPropertyResolver;
import org.springframework.stereotype.Repository;

import com.mahabala.model.model;

import reactor.core.publisher.Flux;
@Repository
public class ModelDao {

	private static void sleepExecution(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	public List<model> getall(){
//	return	IntStream.rangeClosed(1,50)
//			.peek(ModelDao::sleepExecution)
//		.peek(e-> System.out.println("process count"+e))
//		.mapToObj(i->new model(i,"customer"+i))
//		.collect(Collectors.toList());
//		
//	}
	public Flux<model> getall(){
		return Flux.range(1, 20)
			.delayElements(Duration.ofSeconds(1))
			.doOnNext(i->System.out.println("processing time :"+i))
		    .map(i->new model(i ,"customer"+i));
		}
	
	public Flux<model> getallmodelObjects(){
		return Flux.range(1, 20)
			.doOnNext(i->System.out.println("processing time in stream flow :"+i))
		    .map(i->new model(i ,"customer"+i));
		}
}
