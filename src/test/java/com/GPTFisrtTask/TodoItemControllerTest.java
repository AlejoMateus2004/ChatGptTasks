package com.GPTFisrtTask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TodoItemController.class)
public class TodoItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoItemService todoItemService;

    @Test
    public void testGetAllTodoItems() throws Exception {
        List<TodoItem> todoItemList = new ArrayList<>();
        todoItemList.add(new TodoItem(1L, "Todo 1", "Description 1"));
        todoItemList.add(new TodoItem(2L, "Todo 2", "Description 2"));
        when(todoItemService.getAllTodoItems()).thenReturn(todoItemList);

        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("Todo 1"))
                .andExpect(jsonPath("$[1].title").value("Todo 2"));
    }

    @Test
    public void testGetTodoItemById() throws Exception {
        Long id = 1L;
        TodoItem todoItem = new TodoItem(id, "Todo 1", "Description 1");
        when(todoItemService.getTodoItemById(id)).thenReturn(Optional.of(todoItem));

        mockMvc.perform(get("/api/todo/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Todo 1"));
    }

    @Test
    public void testCreateTodoItem() throws Exception {
        TodoItem todoItem = new TodoItem(1L,"Todo 1", "Description 1");
        when(todoItemService.createTodoItem(any(TodoItem.class))).thenReturn(todoItem);

        mockMvc.perform(post("/api/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"Todo 1\", \"description\": \"Description 1\" }"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Todo 1"));
    }

    @Test
    public void testUpdateTodoItem() throws Exception {
        Long id = 1L;
        TodoItem updatedTodoItem = new TodoItem(id, "Updated Todo 1", "Updated Description 1");
        when(todoItemService.updateTodoItem(eq(id), any(TodoItem.class))).thenReturn(updatedTodoItem);

        mockMvc.perform(put("/api/todo/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"Updated Todo 1\", \"description\": \"Updated Description 1\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Updated Todo 1"));
    }

    @Test
    public void testDeleteTodoItem() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/api/todo/{id}", id))
                .andExpect(status().isNoContent());

        verify(todoItemService, times(1)).deleteTodoItem(id);
    }
}
