package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseTest {
    Exercise squats;
    Exercise crunches;
    Exercise pushups;
    Exercise planks;


    @BeforeEach
    public void runBefore() {
        squats = new Exercise("squats", "lower-back",60, 40);
        crunches = new Exercise("crunches", "abs", 30, 60);
        pushups = new Exercise("pushups", "upper-body", 30, 50);
        planks = new Exercise("planks", "upper-body", 30, 75);
    }

    @Test
    public void testGetExerciseName() {
        assertEquals("squats", squats.getExerciseName());
        assertEquals("crunches", crunches.getExerciseName());
        assertEquals("pushups", pushups.getExerciseName());
        assertEquals("planks", planks.getExerciseName());

    }

    @Test
    public void testGetExerciseType() {
        assertEquals("lower-back", squats.getExerciseType());
        assertEquals("abs", crunches.getExerciseType());
        assertEquals("upper-body", pushups.getExerciseType());
        assertEquals("upper-body", planks.getExerciseType());
    }

    @Test
    public void testGetExerciseDuration() {
        assertEquals(60, squats.getExerciseDuration());
        assertEquals(30, crunches.getExerciseDuration());
        assertEquals(30, pushups.getExerciseDuration());
        assertEquals(30, planks.getExerciseDuration());

    }

    @Test
    public void testGetCaloriesBurnt() {
        assertEquals(40, squats.getCaloriesBurnt());
        assertEquals(60, crunches.getCaloriesBurnt());
        assertEquals(50, pushups.getCaloriesBurnt());
        assertEquals(75, planks.getCaloriesBurnt());

    }
}