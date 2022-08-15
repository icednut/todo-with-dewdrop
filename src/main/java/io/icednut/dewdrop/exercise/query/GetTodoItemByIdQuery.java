package io.icednut.dewdrop.exercise.query;

import java.util.UUID;

public class GetTodoItemByIdQuery {

    private UUID todoItemId;

    public GetTodoItemByIdQuery(UUID todoItemId) {
        this.todoItemId = todoItemId;
    }

    public UUID getTodoItemId() {
        return todoItemId;
    }
}
