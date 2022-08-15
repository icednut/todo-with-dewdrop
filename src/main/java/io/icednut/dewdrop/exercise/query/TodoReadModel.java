package io.icednut.dewdrop.exercise.query;

import events.dewdrop.api.result.Result;
import events.dewdrop.read.readmodel.annotation.DewdropCache;
import events.dewdrop.read.readmodel.annotation.EventHandler;
import events.dewdrop.read.readmodel.annotation.ReadModel;
import events.dewdrop.read.readmodel.annotation.Stream;
import events.dewdrop.read.readmodel.query.QueryHandler;
import io.icednut.dewdrop.exercise.event.TodoItemCreated;
import io.icednut.dewdrop.exercise.model.TodoItemDetails;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
@ReadModel(ephemeral = true, destroyInMinutesUnused = 1)
@Stream(name = "TodoAggregate", subscribed = true)
public class TodoReadModel {

    @DewdropCache
    private Map<UUID, TodoItemDetails> cache = new HashMap<>();

    @EventHandler
    public void on(TodoItemCreated event) {
        this.cache.put(
                event.getTodoItemId(),
                new TodoItemDetails(event.getTodoItemId(), event.getContent())
        );
    }

    @QueryHandler
    public Result<TodoItemDetails> handle(GetTodoItemByIdQuery query) {
        return Optional.ofNullable(cache.get(query.getTodoItemId()))
                .map(todoItem -> Result.of(todoItem))
                .orElse(Result.empty());
    }
}
