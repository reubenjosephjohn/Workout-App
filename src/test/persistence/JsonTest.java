package persistence;

import model.Exercise;
import model.Session;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected void checkSession(String name, int length, Session session) {
        assertEquals(name, session.getSessionName());
        assertEquals(length, session.getLength());
    }

    protected void checkExercise(String exerciseName, int exerciseSets, int exerciseReps, int exerciseDuration,
                                 int CaloriesBurnt, Exercise exc) {
        assertEquals(exerciseName, exc.getExerciseName());
        assertEquals(exerciseSets, exc.getExerciseSets());
        assertEquals(exerciseReps, exc.getExerciseReps());
        assertEquals(exerciseDuration, exc.getExerciseDuration());
        assertEquals(CaloriesBurnt, exc.getCaloriesBurnt());
    }
}
