package io.icednut.dewdrop.exercise.event;

import events.dewdrop.aggregate.annotation.AggregateId;
import events.dewdrop.structure.api.Event;

import java.util.UUID;

public abstract class TodoEvent extends Event {

    @AggregateId
    private UUID todoItemId;

    public TodoEvent() {
    }

    public TodoEvent(UUID todoItemId) {
        super();
        this.todoItemId = todoItemId;
    }

    public UUID getTodoItemId() {
        return todoItemId;
    }
}
