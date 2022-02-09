package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExercisesListTest {

    ExercisesList excList1;
    ExercisesList excList2;
    ExercisesList excList3;

    Exercise squats;
    Exercise crunches;
    Exercise pushups;
    Exercise planks;

    @BeforeEach
    public void runBefore() {
        excList1 = new ExercisesList();
        excList2 = new ExercisesList();
        excList3 = new ExercisesList();

        squats = new Exercise("squats", "lower-back",60, 40);
        crunches = new Exercise("crunches", "abs", 30, 60);
        pushups = new Exercise("pushups", "upper-body", 30, 50);
        planks = new Exercise("planks", "upper-body", 30, 75);
    }

    @Test
    public void testAddExercise() {
        excList1.addExercise(squats);
        excList2.addExercise(squats);
        excList2.addExercise(pushups);
        excList3.addExercise(crunches);
        excList3.addExercise(planks);

        assertTrue(excList1.hasExercise(squats));
        assertTrue(excList2.hasExercise(squats));
        assertTrue(excList2.hasExercise(pushups));
        assertTrue(excList3.hasExercise(crunches));
        assertTrue(excList3.hasExercise(planks));

        assertFalse(excList1.hasExercise(crunches));
        assertFalse(excList2.hasExercise(planks));
        assertFalse(excList3.hasExercise(squats));
    }

    @Test
    public void testRemoveExercise() {
        excList1.addExercise(squats);
        excList1.addExercise(pushups);
        excList1.addExercise(planks);
        excList2.addExercise(squats);
        excList2.addExercise(pushups);
        excList2.addExercise(crunches);
        excList3.addExercise(crunches);
        excList3.addExercise(planks);
        excList3.addExercise(squats);

        excList1.removeExercise(pushups);
        excList1.removeExercise(planks);
        excList2.removeExercise(crunches);
        excList3.removeExercise(squats);

        assertFalse(excList1.hasExercise(pushups));
        assertFalse(excList1.hasExercise(planks));
        assertFalse(excList2.hasExercise(crunches));
        assertFalse(excList3.hasExercise(squats));


        assertTrue(excList1.hasExercise(squats));
        assertTrue(excList2.hasExercise(squats));
        assertTrue(excList2.hasExercise(pushups));
        assertTrue(excList3.hasExercise(crunches));
        assertTrue(excList3.hasExercise(planks));

    }

    @Test
    public void testHasExercise() {
        excList1.addExercise(squats);
        excList1.addExercise(crunches);
        excList1.addExercise(pushups);
        excList2.addExercise(squats);
        excList3.addExercise(planks);
        excList3.addExercise(pushups);

        assertTrue(excList1.hasExercise(squats));
        assertTrue(excList1.hasExercise(pushups));
        assertTrue(excList2.hasExercise(squats));
        assertFalse(excList2.hasExercise(pushups));
        assertFalse(excList3.hasExercise(crunches));
        assertTrue(excList3.hasExercise(planks));
        assertTrue(excList3.hasExercise(pushups));
        assertTrue(excList1.hasExercise(crunches));
        assertFalse(excList2.hasExercise(planks));
        assertFalse(excList3.hasExercise(squats));


    }
}
