package com.mahabala;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import com.mahabala.Controller.MangoController;
import com.mahabala.Service.ProductService;
import com.mahabala.dto.productDto;
import com.mongodb.internal.connection.tlschannel.NeedsWriteException;

import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@WebMvcTest(MangoController.class)
@ExtendWith(SpringExtension.class)
public class spring_mongo_Test {

	@Autowired
	private WebTestClient webClient;

	@MockBean
	private ProductService service;

	@Test
	public void addproductTest() {
		Mono<productDto> productMono = Mono.just(new productDto("1", "mobile", "v1", 1, 1));
		when(service.saveproduct(productMono)).thenReturn(productMono);
		webClient.post().uri("/products")
		.body(Mono.just(productMono), productDto.class)
		.exchange()
		.expectStatus()
		.isOk();
	}

	@Test
	public void getproducts() {
		Flux<productDto> productFlux = Flux.just(new productDto("1", "mobile", "v1", 1, 1),
				new productDto("1", "mobile", "v1", 1, 1));
		when(service.getproductsFlux()).thenReturn(productFlux);

		Flux<productDto> responseFlux = webClient.post().uri("/products")
				.body(Mono.just(productFlux), productDto.class)
				.exchange()
				.expectStatus()
				.isOk()
				.returnResult(productDto.class)
				.getResponseBody();

		StepVerifier.create(responseFlux)
		.expectSubscription()
		.expectNext(new productDto("1", "mobile", "v1", 1, 1))
		.expectNext(new productDto("1", "mobile", "v1", 1, 1))
		.verifyComplete();

	}
	@Test
	public void testgetallproducts() {
			Mono<productDto> productdMono= Mono.just(new productDto("1", "mobile", "v1", 1, 1));
			when(service.getprodMono(any())).thenReturn(productdMono);
			
			Flux<productDto> responsebodyFlux= webClient.get().uri("/products/102")
					.exchange()
					.expectStatus()	.isOk()
					.returnResult(productDto.class)
					.getResponseBody();
			
			StepVerifier.create(responsebodyFlux)
			.expectSubscription()
			.expectNextMatches(p->p.getName()
			.equals("mobile"))
			.verifyComplete();
}
	
	@Test
	public void updateProducttest() {
			Mono<productDto> productMono=Mono.just(new productDto("1", "mobile", "v1", 1, 1));
			when(service.updateMono(productMono, "1"))
			.thenReturn(productMono);
			
			Flux<productDto> responseFlux = webClient.put()
					.uri("/update/{id}")
					.body(Mono.just(productMono), productDto.class)
					.exchange()
					.expectStatus()
					.isOk()
					.returnResult(productDto.class)
					.getResponseBody();

	}
	@Test
	public void deleteproduct() {
	BDDMockito.given(service.deleteMono(any())).willReturn(Mono.empty());
	
	 webClient.delete()
			.uri("/delete/{id}")
			.exchange()
			.expectStatus()
			.isOk();
			}
}
