package com.tuvieja.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.garbarino.gcommons.rest.RestConnectorBuilder;
import com.garbarino.gcommons.rest.impl.RestConnector;
import com.tuvieja.cart.service.CartService;

@Configuration
public class AppConfiguration {

	@Bean
	public RestConnector compumundoRestConnector() {
		return new RestConnector("api-ci.compumundo.com", "");
	}

	@Bean
	public RestConnector garbaRestConnector() {
		return RestConnectorBuilder.customRestConnector().withEndpoint("api-ci.garbarino.com").withConnectionTimeout(30)
				.withReadTimeout(30).build();
	}

	// preguntar a shima como arreglarlo
	@Bean
	public CartService cartService() {
		return new CartService();

	}
}
