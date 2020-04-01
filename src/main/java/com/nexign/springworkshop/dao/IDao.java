package com.nexign.springworkshop.dao;

import com.nexign.springworkshop.dto.Todo;

import java.util.List;

public interface IDao {

    public Todo addTodo(Todo todo);

    public List<Todo> fetchAll();

    public void delete(String id);

    public void changeStatus(String id);
}
