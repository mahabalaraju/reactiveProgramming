 package com.mahabala.router;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mahabala.Dao.ModelDao;
import com.mahabala.handler.CustomerStreamHandler;
import com.mahabala.handler.modelhandler;

import reactor.core.publisher.Mono;

@Configuration
public class RouterConfig {

	@Autowired 
   private modelhandler modelhandler;

	@Autowired
	private CustomerStreamHandler u;
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction(){
		return RouterFunctions.route()
				.GET("/get/Objects",modelhandler::getallconsumers)
				.GET("/get/Objects/Stream",u::getcustomers)
				.GET("/get/Objects/{input}",u::findcustomers)
				.POST("/get/Objects/save",u::savecuMono)	
				.build();
	}
	

}
