package com.nexign.springworkshop.dao;

import com.nexign.springworkshop.dto.Todo;
import lombok.Getter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TodoDao implements IDao {

    @Getter
    private static Map<String, Todo> dao = new HashMap<>();

    private static Random random = new Random();

    public Todo addTodo(Todo todo) {
        String id = new ObjectId().toString();
        todo.setId(id);
        dao.put(id, todo);
        return todo;
    }

    public List<Todo> fetchAll() {
        return new ArrayList<>(dao.values());
    }

    public void delete(String id) {
        dao.remove(id);
    }

    public void changeStatus(String id) {
        Todo todo = dao.get(id);
        todo.setStatus(!todo.isStatus());
        dao.replace(id, todo);
    }
}
