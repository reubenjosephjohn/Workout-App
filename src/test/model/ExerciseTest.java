package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseTest {
    private Exercise exerciseTest;

    @BeforeEach
    public void setup() {
        exerciseTest = new Exercise("Crunches", 3, 10,-1, 50);
    }

    @Test
    public void testConstructor() {
        assertEquals("Crunches", exerciseTest.getExerciseName());
        assertEquals(3, exerciseTest.getExerciseSets());
        assertEquals(10, exerciseTest.getExerciseReps());
        assertEquals(0, exerciseTest.getExerciseDuration());
        assertEquals(50, exerciseTest.getCaloriesBurnt());

    }


    @Test
    public void testChangeName() {
        exerciseTest.changeExerciseName("Squats");
        assertEquals("Squats", exerciseTest.getExerciseName());
    }

    @Test
    public void testChangeSets() {
        exerciseTest.changeExerciseSets(4);
        assertEquals(4, exerciseTest.getExerciseSets());
    }

    @Test
    public void testChangeReps() {
        exerciseTest.changeExerciseReps(12);
        assertEquals(12, exerciseTest.getExerciseReps());
    }

    @Test
    public void testChangeTime() {
        exerciseTest.changeExerciseDuration(60);
        assertEquals(60, exerciseTest.getExerciseDuration());
    }


    @Test
    public void testChangeCaloriesBurnt() {
        exerciseTest.changeCaloriesBurnt(100);
        assertEquals(100, exerciseTest.getCaloriesBurnt());
    }

}
