package com.example.demo.mvc;

import com.example.demo.User;
import org.springframework.stereotype.Repository;

@Repository
public class MvcRepo {

    public User byId(String id) {
        return new User();
    }

    public User save(User u) {
        return u;
    }
}
