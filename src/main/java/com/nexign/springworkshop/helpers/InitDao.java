package com.nexign.springworkshop.helpers;

import com.nexign.springworkshop.dto.Todo;
import com.nexign.springworkshop.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Component
@Profile("dev")
public class InitDao implements CommandLineRunner {

    private final TodoService todoService;

    @Autowired
    public InitDao(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public void run(String... args) throws Exception {
        String[] titleArr = {"test1", "test2", "test3"};
        LongStream.range(0, 3).forEach(value ->
            todoService.addTodo(Todo.builder().title(titleArr[(int)value]).build()));
    }

}
