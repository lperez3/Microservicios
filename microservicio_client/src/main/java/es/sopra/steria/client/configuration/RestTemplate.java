package es.sopra.steria.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RestTemplate {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
