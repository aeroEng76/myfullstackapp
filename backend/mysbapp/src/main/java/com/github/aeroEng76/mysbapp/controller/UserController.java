package com.github.aeroEng76.mysbapp.controller;

import com.github.aeroEng76.mysbapp.model.User;
import com.github.aeroEng76.mysbapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Flux<User> getAllUsers() {

        return userService.findAllUsers();

    }

    @GetMapping("/users/{id}")
    public Mono<User> getUserById(@PathVariable("id") String id) {

        return userService.findById(id);

    }

    @PostMapping("/users")
    public Mono<User> createUser(@RequestBody User user) {

        //return userService.save(new User(user.getFirstName(), user.getLastName(), user.getEmailAddress()));
        return userService.save(user);

    }

    @PutMapping("/users/{id}")
    public Mono<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {

        return userService.update(id, user);

    }

    @DeleteMapping("/users/{id}")
    public Mono<Void> deleteUser(@PathVariable("id") String id) {

        return userService.deleteById(id);

    }

    @DeleteMapping("/users")
    public Mono<Void> deleteAllUsers() {

        return userService.deleteAll();

    }

}
