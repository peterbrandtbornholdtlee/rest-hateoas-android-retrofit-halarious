package com.example;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MessageRepository extends MongoRepository<Message, BigInteger> {

}
