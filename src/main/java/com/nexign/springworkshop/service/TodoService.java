package com.nexign.springworkshop.service;

import com.nexign.springworkshop.dao.IDao;
import com.nexign.springworkshop.dto.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final IDao todoDao;

    @Autowired
    public TodoService(IDao todoDao) {
        this.todoDao = todoDao;
    }

    public Todo addTodo(Todo todo) {
        return todoDao.addTodo(todo);
    }

    public void delete(String id) {
        todoDao.delete(id);
    }

    public List<Todo> fetchAll() {
        return todoDao.fetchAll();
    }

    public void changeStatus(String id) {
        todoDao.changeStatus(id);
    }
}
