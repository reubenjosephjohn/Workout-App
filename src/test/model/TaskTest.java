package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    Task taskone;
    Task tasktwo;
    Task taskthree;

    Exercise squats;
    Exercise crunches;
    Exercise pushups;
    Exercise planks;

    ExercisesList excList1;
    ExercisesList excList2;

    @BeforeEach
    public void runBefore() {
        squats = new Exercise("squats", "lower-back",60, 40);
        crunches = new Exercise("crunches", "abs", 30, 60);
        pushups = new Exercise("pushups", "upper-body", 30, 50);
        planks = new Exercise("planks", "upper-body", 30, 75);

        excList1 = new ExercisesList();
        excList2 = new ExercisesList();

        taskone = new Task("Sunday", crunches ,"Build Abdominal Muscles", false );
        tasktwo = new Task("Monday",squats,"Building Lower-back",false);
        taskthree = new Task("Tuesday",pushups,"Building Upper-body",false);

    }

    @Test
    public void testGetTaskDescription() {
        assertEquals("Build Abdominal Muscles", taskone.getTaskDescription());
        assertEquals("Building Lower-back", tasktwo.getTaskDescription());

    }

    @Test
    public void testGetTaskDay() {
        assertEquals("Sunday", taskone.getTaskDay());
        assertEquals("Monday",tasktwo.getTaskDay());
    }

    @Test
    public void testGetTaskExerciseName() {
        assertEquals("crunches", taskone.getTaskExerciseName());
        assertEquals("squats",tasktwo.getTaskExerciseName());

    }

    @Test
    public void testGetExerciseDuration() {
        assertEquals(30,taskone.getTaskExerciseDuration());
        assertEquals(60,tasktwo.getTaskExerciseDuration());
        assertEquals(30,taskthree.getTaskExerciseDuration());

    }

    @Test
    public void testGetTaskFinished() {
        assertEquals(false, taskone.getTaskFinished());
        assertEquals(false, tasktwo.getTaskFinished());
        assertEquals(false, taskthree.getTaskFinished());

        taskone.setFinished();
        tasktwo.setFinished();
        taskthree.setFinished();

        assertEquals(true, taskone.getTaskFinished());
        assertEquals(true, tasktwo.getTaskFinished());
        assertEquals(true, taskthree.getTaskFinished());


    }

}
