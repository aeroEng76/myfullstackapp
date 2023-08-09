package com.github.aeroEng76.mysbapp.configuration;

import com.github.aeroEng76.mysbapp.model.User;
import com.github.aeroEng76.mysbapp.repository.UserRepository;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

import java.util.concurrent.ThreadLocalRandom;

public class MongoConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "users";
    }

    @Override
    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://root:mongopw@localhost:27017");
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }

    @Bean
    @ConditionalOnProperty(prefix = "job.autorun", name = "enabled", havingValue = "true", matchIfMissing = true)
    public CommandLineRunner loadData(UserRepository repository) {
        return (args) -> {
            // save a couple of users
            var users = Flux.just(
                    new User(ThreadLocalRandom.current().nextInt(1, 100), "Adam", "Arrowsmith", "test@test.com" )
            );
            repository.saveAll(users).subscribe();
        };
    }
}
