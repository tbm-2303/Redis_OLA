package com.example.redisapi.controller;

import com.example.redisapi.model.User;
import com.example.redisapi.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> get(@PathVariable String id) {
        return repository.findById(id);
    }

    @GetMapping
    public Iterable<User> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        return repository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}
