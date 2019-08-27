package com.example.demo.reactive;

import com.example.demo.Bind;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

@Configuration
public class RoutingConfig {

    @Bean
    RouterFunction<ServerResponse> routing(ReactiveRepository repository) {
        return route().POST("/", s -> repository.byId(s.pathVariable("id"))
                .flatMap(d -> s.bodyToMono(Bind.class).flatMap(b -> just(d.bind(b))))
                .flatMap(repository::save)
                .then(ok().build()))
                .build();
    }
}
