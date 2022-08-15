package io.icednut.dewdrop.exercise.event;

import java.util.UUID;

public class TodoItemCreated extends TodoEvent {

    private String content;

    public TodoItemCreated() {
        super();
    }

    public TodoItemCreated(UUID todoItemId, String content) {
        super(todoItemId);
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
