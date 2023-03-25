package com.microservice.user.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
@Configuration
public class FeignClientInterceptor implements RequestInterceptor {

	private @Autowired OAuth2AuthorizedClientManager manager;

	@Override
	public void apply(RequestTemplate template) {

		template.header("Authorization", "Bearer " + manager.authorize(
				OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build())
				.getAccessToken().getTokenValue());
	}

}
