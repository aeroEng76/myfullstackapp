package com.github.aeroEng76.mysbapp.service;

import com.github.aeroEng76.mysbapp.model.User;
import com.github.aeroEng76.mysbapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAllUsers() {

        return userRepository.findAll();

    }

    public Mono<User> findById(String id) {

        return userRepository.findById(id);

    }

    public Mono<User> save(User user) {

        return userRepository.save(user);

    }

    public Mono<User> update(String id, User user) {
        return userRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTutorial -> {
                    if (optionalTutorial.isPresent()) {
                        user.setId(id);
                        return userRepository.save(user);
                    }

                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(String id) {

        return userRepository.deleteById(id);

    }

    public Mono<Void> deleteAll() {

        return userRepository.deleteAll();

    }

}