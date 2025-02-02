package org.melogtm.melcash.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AuthService {

    private final WebClient webClient;

    public AuthService(WebClient.Builder builder, @Value("${auth.url.api}") String authUrl) {
        this.webClient = builder.baseUrl(authUrl).build();
    }

    public boolean isAuthorized() {
         Integer status = webClient.get()
                 .exchangeToMono(response -> Mono.just(response.statusCode().value()))
                 .block();

        System.out.println("Professional DEBUG: (RESPONSE) " + status);

        return status != null && status == 200;
    }
}
