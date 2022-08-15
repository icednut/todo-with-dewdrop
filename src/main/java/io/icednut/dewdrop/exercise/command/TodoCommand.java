package io.icednut.dewdrop.exercise.command;

import events.dewdrop.aggregate.annotation.AggregateId;
import events.dewdrop.structure.api.Command;

import java.util.UUID;

public abstract class TodoCommand extends Command {

    @AggregateId
    private UUID todoItemId;

    public TodoCommand(UUID todoItemId) {
        super();
        this.todoItemId = todoItemId;
    }

    public UUID getTodoItemId() {
        return todoItemId;
    }
}
