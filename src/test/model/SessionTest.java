package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionTest {
    private Session testSession;

    @BeforeEach
    public void setup() {
        testSession = new Session("Session 1");
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testSession.getLength());
        assertEquals(0, testSession.getTimeTaken());
        assertEquals("Session 1", testSession.getSessionName());
    }

    @Test
    public void testAddExercise() {
        Exercise ex = new Exercise("Push-ups", 3, 10, 30, 45);
        testSession.addExercise(ex);
        assertEquals(1, testSession.getLength());
    }

    @Test
    public void testRemoveExerciseOne() {
        Exercise ex = new Exercise("Push-ups", 3, 10, 30,45);
        testSession.addExercise(ex);
        assertEquals(1, testSession.getLength());
        testSession.removeExercise("Push-ups");
        assertEquals(0, testSession.getLength());
    }

    @Test
    public void testRemoveMultipleExercise() {
        Exercise ex1 = new Exercise("Push-ups", 3, 10, 30,45);
        Exercise ex2 = new Exercise("Squats", 4, 15, 45,90);
        Exercise ex3 = new Exercise("Crunches", 5, 10, 60,100);
        testSession.addExercise(ex1);
        testSession.addExercise(ex2);
        testSession.addExercise(ex3);
        assertEquals(3, testSession.getLength());
        testSession.removeExercise("Push-ups");
        assertEquals(2,testSession.getLength());
    }

    @Test
    public void testRemoveNoExercise() {
        Exercise ex1 = new Exercise("Push-ups", 3, 10, 30,45);
        Exercise ex2 = new Exercise("Squats", 4, 15, 45,90);
        Exercise ex3 = new Exercise("Crunches", 5, 10, 60,100);
        testSession.addExercise(ex1);
        testSession.addExercise(ex2);
        testSession.addExercise(ex3);
        assertEquals(3, testSession.getLength());
        testSession.removeExercise("crunches");
        assertEquals(3,testSession.getLength());
    }

    @Test
    public void testAddTime() {
        testSession.addTime(50);
        assertEquals(50, testSession.getTimeTaken());
    }

    @Test
    public void testRemoveTime() {
        testSession.addTime(200);
        testSession.removeTime(20);
        assertEquals(180, testSession.getTimeTaken());
        testSession.removeTime(200);
        assertEquals(0, testSession.getTimeTaken());
    }

    @Test
    public void testSetTime() {
        testSession.addTime(45);
        testSession.setTime(50);
        assertEquals(50, testSession.getTimeTaken());
    }

    @Test
    public void testSetName() {
        testSession.setSessionName("Abs");
        assertEquals("Abs",testSession.getSessionName());
    }

    @Test
    public void testGetExercises() {
        Exercise ex1 = new Exercise("Push-ups", 3, 10, 30,45);
        Exercise ex2 = new Exercise("Squats", 4, 15, 45,90);
        Exercise ex3 = new Exercise("Crunches", 5, 10, 60,100);
        testSession.addExercise(ex1);
        testSession.addExercise(ex2);
        testSession.addExercise(ex3);
        assertEquals(3, testSession.getExercises().size());
        assertEquals("Push-ups", testSession.getExercises().get(0).getExerciseName());
        assertEquals("Squats", testSession.getExercises().get(1).getExerciseName());
        assertEquals("Crunches", testSession.getExercises().get(2).getExerciseName());

    }

}