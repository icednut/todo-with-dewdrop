package io.icednut.dewdrop.exercise.model;

import events.dewdrop.read.readmodel.annotation.PrimaryCacheKey;

import java.util.UUID;

public class TodoItemDetails {

    @PrimaryCacheKey
    private UUID todoItemId;
    private String content;

    public TodoItemDetails(UUID todoItemId, String content) {
        this.todoItemId = todoItemId;
        this.content = content;
    }

    public UUID getTodoItemId() {
        return todoItemId;
    }

    public String getContent() {
        return content;
    }
}
