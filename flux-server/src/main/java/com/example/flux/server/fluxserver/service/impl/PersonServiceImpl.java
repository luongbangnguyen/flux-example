package com.example.flux.server.fluxserver.service.impl;

import com.example.flux.server.fluxserver.model.Person;
import com.example.flux.server.fluxserver.service.PersonService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Flux<Person> readAll() {
        return Flux.create(personFluxSink -> {
            try {
                int index = 0;
                while (index < 300) {
                    index++;
                    Thread.sleep(100L);
                    personFluxSink.next(new Person(String.valueOf(index), "first name " + index, "last name " + index));
                }
                personFluxSink.complete();
            } catch (Exception ex) {
                ex.printStackTrace();
                personFluxSink.complete();
            }
        });
    }

    @Override
    public Mono<Person> getPerson() {
        return Mono.just(new Person("1", "fist name", "last name"));
    }
}
