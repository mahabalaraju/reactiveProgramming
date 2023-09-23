package com.mahabala.Repository;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.mahabala.Entity.products;
import com.mahabala.dto.productDto;

import reactor.core.publisher.Flux;
@Repository
public interface productRepository extends ReactiveMongoRepository<products, String> {

	Flux<productDto> findByPriceBetween(Range<Double> priceRange);

}
