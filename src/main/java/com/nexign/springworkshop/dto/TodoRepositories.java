package com.nexign.springworkshop.dto;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepositories extends MongoRepository<Todo, Long> {
}
