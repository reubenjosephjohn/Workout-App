package model;

// Represents an exercise with name, sets, reps, duration and calories burnt
public class Exercise {
    private String exerciseName; // name of the exercise
    private int exerciseSets; //number of sets
    private int exerciseReps; // number of reps
    private int exerciseDuration; // duration of the exercise (in seconds)
    private int caloriesBurnt; // number of calories burnt

    // REQUIRES: exerciseName,exerciseSets, caloriesBurnt, exerciseReps, exerciseWeight shouldn't be empty;
    // exerciseDuration>0
    // EFFECTS: Constructs an exercise with its name, sets,reps and calories burnt.
    // exerciseDuration = duration if duration >=0; else exerciseDuration=0
    public Exercise(String name, int sets, int reps, int duration, int caloriesBurnt) {
        this.exerciseName = name;
        this.exerciseSets = sets;
        this.exerciseReps = reps;
        this.caloriesBurnt = caloriesBurnt;

        if (duration >= 0) {
            exerciseDuration = duration;
        } else {
            exerciseDuration = 0;
        }

    }

    // EFFECTS: returns name of the exercise
    public String getExerciseName() {
        return exerciseName;
    }

    // EFFECTS: returns number of sets
    public int getExerciseSets() {
        return exerciseSets;
    }

    // EFFECTS: returns the duration of the exercise
    public int getExerciseDuration() {
        return exerciseDuration;
    }

    // EFFECTS: returns the calories burnt during the duration of the exercise
    public int getCaloriesBurnt() {
        return caloriesBurnt;
    }

    // EFFECTS: returns number of reps
    public int getExerciseReps() {
        return exerciseReps;
    }

    // MODIFIES: this
    // EFFECTS: changes exerciseName to str
    public void changeExerciseName(String str) {
        exerciseName = str;
    }

    // MODIFIES: this
    // EFFECTS: changes exerciseSets to s
    public void changeExerciseSets(int s) {
        exerciseSets = s;
    }

    // MODIFIES: this
    // EFFECTS: changes exerciseDuration to d
    public void changeExerciseDuration(int d) {
        exerciseDuration = d;
    }

    // MODIFIES: this
    // EFFECTS: changes exerciseReps to r
    public void changeExerciseReps(int r) {
        exerciseReps = r;
    }

    // MODIFIES: this
    // EFFECTS: changes caloriesBurnt to c
    public void changeCaloriesBurnt(int c) {
        caloriesBurnt = c;
    }




}
