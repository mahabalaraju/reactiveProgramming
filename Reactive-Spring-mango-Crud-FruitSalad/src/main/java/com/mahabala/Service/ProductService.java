package com.mahabala.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.data.repository.config.RepositoryBeanDefinitionParser;
import org.springframework.stereotype.Service;

import com.mahabala.Repository.productRepository;
import com.mahabala.Utils.AppUtils;
import com.mahabala.dto.productDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

	@Autowired
	private productRepository repository;

	public Flux<productDto> getproductsFlux() {
		return repository.findAll().map(AppUtils::entitytoDto);
	}

	public Mono<productDto> getprodMono(String id) {
		return repository.findById(id).map(AppUtils::entitytoDto);
	}

	public Flux<productDto> getproductsinrange(double min, double max) {
		return repository.findByPriceBetween(Range.closed(min, max));
	}

	public Mono<productDto> saveproduct(Mono<productDto> productdtoMono) {
		return productdtoMono.map(AppUtils::dtotoProducts).flatMap(repository::insert).map(AppUtils::entitytoDto);

	}
    
	public Mono<productDto> updateMono(Mono<productDto> produMono,String id){
		return repository.findById(id)
				.flatMap(e->produMono.map(AppUtils::dtotoProducts))
				.doOnNext(e->e.setId(id))
				.flatMap(repository::save)
				.map(AppUtils::entitytoDto);			    
	}
	
	public Mono<Void> deleteMono(String id){
		return repository.deleteById(id);
		}
}
