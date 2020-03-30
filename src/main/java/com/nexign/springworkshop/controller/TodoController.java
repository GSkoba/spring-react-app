package com.nexign.springworkshop.controller;

import com.nexign.springworkshop.dto.Todo;
import com.nexign.springworkshop.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/addTodo")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @GetMapping("/fetchAll")
    public List<Todo> fetchAll() {
        return todoService.fetchAll();
    }

    @GetMapping("/delete")
    public List<Todo> delete(@RequestParam("id") long id) {
        todoService.delete(id);
        return todoService.fetchAll();
    }

    @GetMapping("/changeStatus")
    public void changeStatus(@RequestParam("id") long id) {
        todoService.changeStatus(id);
    }
}
