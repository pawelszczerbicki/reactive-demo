package com.example.demo;

import java.util.HashSet;
import java.util.Set;

public class User {

    private Set<Bind> binds = new HashSet<>();

    public User bind(Bind b) {
        binds.add(b);
        return this;
    }
}
