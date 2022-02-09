package model;

import java.util.ArrayList;

// Represents an ExerciseList that is part of a workout
public class ExercisesList {
    ArrayList<Exercise> exercises;

    // EFFECTS: Constructs an ExercisesList
    public ExercisesList() {
        exercises = new ArrayList<Exercise>();
    }

    // REQUIRES: Exercise must be there
    // MODIFIES: this
    // EFFECTS: Adds a given exercise to the list of exercises
    public void addExercise(Exercise exc) {
        exercises.add(exc);
    }

    // REQUIRES: Exercise must be in the ExercisesList
    // MODIFIES: this
    // EFFECTS: Removes given exercise from the ExercisesList
    public void removeExercise(Exercise exc) {
        exercises.remove(exc);
    }

    // EFFECTS: Returns true if Exercise is present in ExercisesList
    public Boolean hasExercise(Exercise exc) {
        return exercises.contains(exc);
    }
}
