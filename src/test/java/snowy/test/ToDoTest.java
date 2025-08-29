package snowy.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void toDoFormatCheck() {
        ToDo todo = new ToDo("return book");
        assertEquals("[T][ ] return book", todo.toString());
    }
}
