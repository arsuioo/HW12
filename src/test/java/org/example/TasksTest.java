package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void simpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвони");
        Assertions.assertTrue(actual);
    }

    @Test
    public void simpleTaskFolse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Доложить");
        Assertions.assertFalse(actual);
    }

    @Test
    public void epicTrue() {
        Epic epic = new Epic(2, new String[]{"Позвони, Сделай"});

        boolean actual = epic.matches("Позвони");
        Assertions.assertTrue(actual);
    }

    @Test
    public void epicFolse() {
        Epic epic = new Epic(2, new String[]{"Позвони, Сделай"});

        boolean actual = epic.matches("Набери, прочитай");
        Assertions.assertFalse(actual);
    }

    @Test
    public void meetingFolse() {
        Meeting meeting = new Meeting(22, "", "", "");

        boolean actual = meeting.matches("QA");
        Assertions.assertFalse(actual);
    }

    @Test
    public void meetingTrueTopic() {
        Meeting meeting = new Meeting(22, "QA", "", "");

        boolean actual = meeting.matches("QA");
        Assertions.assertTrue(actual);
    }

    @Test
    public void meetingTrueProject() {
        Meeting meeting = new Meeting(22, "", "AutoTests", "");

        boolean actual = meeting.matches("Test");
        Assertions.assertTrue(actual);
    }

}