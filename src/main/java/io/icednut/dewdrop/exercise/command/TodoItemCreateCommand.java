package io.icednut.dewdrop.exercise.command;

import java.util.UUID;

public class TodoItemCreateCommand extends TodoCommand {

    private final String content;

    public TodoItemCreateCommand(UUID todoItemId, String content) {
        super(todoItemId);
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
