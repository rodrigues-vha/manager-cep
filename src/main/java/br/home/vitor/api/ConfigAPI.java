package br.home.vitor.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ConfigAPI {
	
	@Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder
                .baseUrl("https://viacep.com.br/ws")
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
