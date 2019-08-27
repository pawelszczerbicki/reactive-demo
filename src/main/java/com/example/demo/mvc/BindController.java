package com.example.demo.mvc;

import com.example.demo.Bind;
import com.example.demo.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BindController {

    private final MvcRepo repo;

    public BindController(MvcRepo repo) {
        this.repo = repo;
    }

    @PostMapping
    public void addBind(@RequestBody Bind bind, @PathVariable String id) {
        User u = repo.byId(id);
        u.bind(bind);
        repo.save(u);
    }
}
