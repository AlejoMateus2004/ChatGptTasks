package com.GPTFisrtTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping
    public List<TodoItem> getAllTodoItems() {
        return todoItemService.getAllTodoItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable Long id) {
        Optional<TodoItem> todoItem = todoItemService.getTodoItemById(id);
        return todoItem.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TodoItem> createTodoItem(@RequestBody TodoItem todoItem) {
        TodoItem createdTodoItem = todoItemService.createTodoItem(todoItem);
        return new ResponseEntity<>(createdTodoItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodoItem(@PathVariable Long id, @RequestBody TodoItem todoItem) {
        TodoItem updatedTodoItem = todoItemService.updateTodoItem(id, todoItem);
        if (updatedTodoItem != null) {
            return new ResponseEntity<>(updatedTodoItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable Long id) {
        todoItemService.deleteTodoItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
