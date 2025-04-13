package com.acme.todolist;

import com.acme.todolist.domain.TodoItem;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoItemTest {
    
    @Test
    public void testLateContentLessThan24Hours() {
        TodoItem item = new TodoItem("1", Instant.now().minus(23, ChronoUnit.HOURS), "Content");
        assertEquals("Content", item.finalContent());
    }

    @Test
    public void testLateContentExactly24Hours() {
        TodoItem item = new TodoItem("2", Instant.now().minus(24, ChronoUnit.HOURS), "Content");
        assertEquals("[LATE!] Content", item.finalContent());
    }

    @Test
    public void testLateContentMoreThan24Hours() {
        TodoItem item = new TodoItem("3", Instant.now().minus(25, ChronoUnit.HOURS), "Content");
        assertEquals("[LATE!] Content", item.finalContent());
    }
}
