package io.icednut.dewdrop.exercise.command;

import events.dewdrop.Dewdrop;
import events.dewdrop.api.result.Result;
import events.dewdrop.api.validators.ValidationException;
import events.dewdrop.structure.api.Command;
import io.icednut.dewdrop.exercise.model.TodoItemDetails;
import io.icednut.dewdrop.exercise.query.GetTodoItemByIdQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TodoItemCreateCommandTest {

    @Autowired
    private Dewdrop dewdrop;

    @Test
    public void test_TodoItemCreateCommand() throws ValidationException, InterruptedException {
        final UUID todoItemId = UUID.randomUUID();
        final Command command = new TodoItemCreateCommand(todoItemId, "Study event sourcing");
        dewdrop.executeCommand(command);

        Thread.sleep(3000L);

        final GetTodoItemByIdQuery query = new GetTodoItemByIdQuery(todoItemId);
        final Result<TodoItemDetails> result = dewdrop.executeQuery(query);

        final TodoItemDetails todoItemDetails = result.get();

        assertEquals(todoItemId, todoItemDetails.getTodoItemId());
    }
}
