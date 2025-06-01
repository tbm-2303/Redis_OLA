package com.example.redisapi.controller;

import com.example.redisapi.model.User;
import com.example.redisapi.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.concurrent.TimeUnit;


import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository repository;
    private final RedisTemplate<String, Object> redisTemplate;


    public UserController(UserRepository repository, RedisTemplate<String, Object> redisTemplate) {
        this.repository = repository;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        User savedUser = repository.save(user);

        // Set TTL of 24 hours (86400 seconds)
        redisTemplate.expire("User:" + user.getId(), 86400, TimeUnit.SECONDS);

        return savedUser;
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
