package com.github.aeroEng76.mysbapp.repository;

import com.github.aeroEng76.mysbapp.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Flux<User> findByLastName(String lastName);

}
