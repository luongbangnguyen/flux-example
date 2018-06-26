package com.example.flux.server.fluxserver.service;

import com.example.flux.server.fluxserver.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
    Flux<Person> readAll();
    Mono<Person> getPerson();
}
