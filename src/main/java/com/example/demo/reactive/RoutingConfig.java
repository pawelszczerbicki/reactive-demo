package com.example.demo.reactive;

import com.example.demo.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

@Configuration
public class RoutingConfig {

    @Bean
    RouterFunction<ServerResponse> routing(ReactiveRepository repository) {
        return route().POST("/", s -> repository.byId(s.pathVariable("id"))
                .flatMap(user -> s.bodyToMono(Bind.class).flatMap(bind -> updateBind(user, bind)))
                .flatMap(repository::save)
                .then(ok().build()))
                .build();
    }

    private Mono<User> updateBind(User user, Bind newBind){
        return Mono.fromCallable(() ->{
            user.bind(newBind);
            return user;
        });
    }
}
