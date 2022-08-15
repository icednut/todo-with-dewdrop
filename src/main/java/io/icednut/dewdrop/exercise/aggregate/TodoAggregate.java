package io.icednut.dewdrop.exercise.aggregate;

import events.dewdrop.aggregate.annotation.Aggregate;
import events.dewdrop.aggregate.annotation.AggregateId;
import events.dewdrop.command.CommandHandler;
import events.dewdrop.read.readmodel.annotation.EventHandler;
import io.icednut.dewdrop.exercise.command.TodoItemCreateCommand;
import io.icednut.dewdrop.exercise.event.TodoItemCreated;

import java.util.UUID;

@Aggregate
public class TodoAggregate {

    @AggregateId
    UUID todoItemId;
    String content;

    public TodoAggregate() {
    }

    @CommandHandler
    public TodoItemCreated handle(TodoItemCreateCommand command) {
        return new TodoItemCreated(command.getTodoItemId(), command.getContent());
    }

    @EventHandler
    public void on(TodoItemCreated event) {
        this.todoItemId = event.getTodoItemId();
        this.content = event.getContent();
    }
}
