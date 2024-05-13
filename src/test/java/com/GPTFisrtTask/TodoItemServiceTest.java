package com.GPTFisrtTask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoItemServiceTest {

    @Mock
    private TodoItemRepository todoItemRepository;

    @InjectMocks
    private TodoItemService todoItemService;

    @Test
    public void testGetAllTodoItems() {
        // Given
        List<TodoItem> todoItemList = new ArrayList<>();
        todoItemList.add(new TodoItem(1L, "Todo 1", "Description 1"));
        todoItemList.add(new TodoItem(2L, "Todo 2", "Description 2"));
        when(todoItemRepository.findAll()).thenReturn(todoItemList);

        // When
        List<TodoItem> result = todoItemService.getAllTodoItems();

        // Then
        assertEquals(2, result.size());
        verify(todoItemRepository, times(1)).findAll();
    }

    @Test
    public void testGetTodoItemById() {
        // Given
        Long id = 1L;
        TodoItem todoItem = new TodoItem(id, "Todo 1", "Description 1");
        when(todoItemRepository.findById(id)).thenReturn(Optional.of(todoItem));

        // When
        Optional<TodoItem> result = todoItemService.getTodoItemById(id);

        // Then
        assertEquals(todoItem, result.get());
        verify(todoItemRepository, times(1)).findById(id);
    }

    @Test
    public void testCreateTodoItem() {
        // Given
        TodoItem todoItem = new TodoItem(1L, "Todo 1", "Description 1");
        when(todoItemRepository.save(todoItem)).thenReturn(todoItem);

        // When
        TodoItem result = todoItemService.createTodoItem(todoItem);

        // Then
        assertEquals(todoItem, result);
        verify(todoItemRepository, times(1)).save(todoItem);
    }

    @Test
    public void testUpdateTodoItem() {
        // Given
        Long id = 1L;
        TodoItem existingTodoItem = new TodoItem(id, "Todo 1", "Description 1");
        TodoItem updatedTodoItem = new TodoItem(id, "Updated Todo 1", "Updated Description 1");
        when(todoItemRepository.existsById(id)).thenReturn(true);
        when(todoItemRepository.save(updatedTodoItem)).thenReturn(updatedTodoItem);

        // When
        TodoItem result = todoItemService.updateTodoItem(id, updatedTodoItem);

        // Then
        assertEquals(updatedTodoItem, result);
        verify(todoItemRepository, times(1)).existsById(id);
        verify(todoItemRepository, times(1)).save(updatedTodoItem);
    }

    @Test
    public void testDeleteTodoItem() {
        // Given
        Long id = 1L;

        // When
        todoItemService.deleteTodoItem(id);

        // Then
        verify(todoItemRepository, times(1)).deleteById(id);
    }
}
