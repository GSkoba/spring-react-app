package com.nexign.springworkshop.dao;

import com.nexign.springworkshop.dto.Todo;
import com.nexign.springworkshop.dto.TodoRepositories;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class TodoDaoMongo implements IDao {

    private final TodoRepositories repositories;

    public TodoDaoMongo(TodoRepositories repositories) {
        this.repositories = repositories;
    }

    private static Random random = new Random();

    @Override
    public Todo addTodo(Todo todo) {
        long id = System.currentTimeMillis() >> random.nextInt(4);
        todo.setId(id);
        repositories.save(todo);
        return todo;
    }

    @Override
    public List<Todo> fetchAll() {
        return repositories.findAll();
    }

    @Override
    public void delete(long id) {
        repositories.deleteById(id);
    }

    @Override
    public void changeStatus(long id) {
        Optional<Todo> opTodo = repositories.findById(id);
        opTodo.ifPresent(todo -> {
            todo.setStatus(!todo.isStatus());
            repositories.save(todo);
        });
    }
}
