package com.nexign.springworkshop.dao;

import com.nexign.springworkshop.dto.Todo;
import com.nexign.springworkshop.dto.TodoRepositories;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public class TodoDaoMongo implements IDao {

    private final TodoRepositories repositories;

    public TodoDaoMongo(TodoRepositories repositories) {
        this.repositories = repositories;
    }

    @Override
    public Todo addTodo(Todo todo) {
        String id = new ObjectId().toString();
        todo.setId(id);
        return repositories.save(todo);
    }

    @Override
    public List<Todo> fetchAll() {
        return repositories.findAll();
    }

    @Override
    public void delete(String id) {
        repositories.deleteById(id);
    }

    @Override
    public void changeStatus(String id) {
        Optional<Todo> opTodo = repositories.findById(id);
        opTodo.ifPresent(todo -> {
            todo.setStatus(!todo.isStatus());
            repositories.save(todo);
        });
    }
}
