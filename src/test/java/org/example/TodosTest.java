package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void simpleTaskEpikTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void epicTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void epicZeroTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Йогурт");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testEqualst() {
        Task[] tasks1 = {new SimpleTask(1, "Напиши ")};
        Task[] tasks2 = {new SimpleTask(1, "Позвони")};
        assertArrayEquals(tasks1, tasks2);
    }

    @Test
    public void testEqualsNull() {
        Task task1 = new SimpleTask(1, "Напиши");
        Assertions.assertFalse(task1.equals(null));
    }


    @Test
    public void testEqualsTasksTwo() {
        Task task1 = new SimpleTask(1, "One");
        Task task2 = new SimpleTask(2, "Two");
        Assertions.assertFalse(task1.equals(task2));
    }

    @Test
    public void testEqualsObject() {
        Task task1 = new SimpleTask(1, "One");
        Object object = new Object();
        Assertions.assertFalse(task1.equals(object));
    }

    @Test
    public void test() {
        Task task1 = new SimpleTask(1, "One");
        task1.hashCode();
        Assertions.assertFalse(task1.equals(2));
    }

    @Test
    public void tes2t() {
        Task task1 = new SimpleTask(1, "One");
        task1.hashCode();
        Assertions.assertFalse(task1.matches("dd"));
    }
}



