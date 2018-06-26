package com.example.flux.server.fluxserver.handler;

import com.example.flux.server.fluxserver.model.Person;
import com.example.flux.server.fluxserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {
    @Autowired
    private PersonService personService;

    public Mono<ServerResponse> readAll(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(personService.readAll(), Person.class);
    }
}
