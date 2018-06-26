package com.example.flux.server.fluxserver.router;

import com.example.flux.server.fluxserver.handler.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class RouterPerson {
    @Bean
    public RouterFunction<ServerResponse> routePerson(PersonHandler personHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/person").and(RequestPredicates.accept(MediaType.APPLICATION_STREAM_JSON)), personHandler::readAll);
    }
}
