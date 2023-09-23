package com.mahabala.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahabala.Service.ProductService;
import com.mahabala.dto.productDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class MangoController {
 
	@Autowired
	private ProductService service;
	
	@GetMapping
	public Flux<productDto> products(){
		return service.getproductsFlux();
	}
		
	@GetMapping("/{id}")
	public Mono<productDto> getproductFlux(@PathVariable String id){
			return service.getprodMono(id);
	}
	
	@GetMapping
	public Flux<productDto> getproMonobyMono(@RequestParam("min") double min,@RequestParam("max") double max){
		return service.getproductsinrange(min, max)		;
	}
	 
	@PostMapping
	public Mono<productDto>saveMono(@RequestBody  Mono<productDto> producteMono){
		return service.saveproduct(producteMono);
	}
	
	@PutMapping("/update/{id}")
	public Mono<productDto> update(@RequestBody  Mono<productDto> producteMono,@PathVariable String id){
	return	service.updateMono(producteMono, id);	
		}
	
	@DeleteMapping("/{id}")
	public Mono<Void> dlelete(@PathVariable String id){
		return service.deleteMono(id);
		}
}

















