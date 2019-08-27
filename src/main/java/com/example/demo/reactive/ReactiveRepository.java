package com.example.demo.reactive;

import com.example.demo.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ReactiveRepository {
    public Mono<User> byId(String id) {
        return Mono.just(new User());
    }

    public Mono<User> save(User user) {
        return Mono.just(user);
    }
}
