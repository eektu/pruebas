package com.tuvieja.cart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garbarino.gcommons.rest.RestConnectorBuilder;
import com.garbarino.gcommons.rest.impl.RestConnector;
import com.garbarino.gcommons.serializers.config.ObjectMapperBuilder;

@Configuration
@ComponentScan({"com.garbarino.monga.*"})
public class AppConfiguration {

	@Value("${endpoints.apiGarba}")
	private String apiGarba;
	
	@Value("${endpoints.apiCompu}")
	private String apiCompu;
	
	
	
	@Bean
	public ObjectMapper objectMapper() {
		return ObjectMapperBuilder.standardObjectMapper().build();
	}
	
	@Bean
	public RestConnector compumundoRestConnector() {
		return new RestConnector(apiCompu, "");
	}

	@Bean
	public RestConnector garbaRestConnector() {
		return RestConnectorBuilder.customRestConnector()
				.withEndpoint(apiGarba)
				.withConnectionTimeout(30)
				.withReadTimeout(30).build();
	}

}
