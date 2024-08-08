package com.atipera.api.github.config;

import com.atipera.api.github.model.ErrorResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GitHubConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
