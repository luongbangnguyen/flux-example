package com.example.flux.server.fluxserver.client;

import com.example.flux.server.fluxserver.model.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;

@Component
public class Client {
    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .build();

    public Disposable readAllPerson() {
        return this.webClient.get().uri("/person")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .flatMapMany(response -> response.bodyToFlux(Person.class))
                .subscribe(System.out::println);
    }
}
