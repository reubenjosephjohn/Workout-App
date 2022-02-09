package model;

// Represents an exercise with the name,type duration and calories burnt
public class Exercise {
    private String exerciseName;
    private String exerciseType;
    private int exerciseDuration;
    private int caloriesBurnt;

    // REQUIRES: name,type duration and caloriesburnt shouldn't be empty
    // EFFECTS: Constructs an exercise with its name, time and calories burnt.
    public Exercise(String name, String type, int duration, int caloriesburnt) {
        this.exerciseName = name;
        this.exerciseType = type;
        this.exerciseDuration = duration;
        this.caloriesBurnt = caloriesburnt;

    }

    // EFFECTS: returns name of the exercise
    public String getExerciseName() {
        return exerciseName;
    }

    // EFFECTS: returns the type of exercise
    public String getExerciseType() {
        return exerciseType;
    }

    // EFFECTS: returns the duration of the exercise
    public double getExerciseDuration() {
        return exerciseDuration;
    }

    // EFFECTS: returns the calories burnt during the duration of the exercise
    public double getCaloriesBurnt() {
        return caloriesBurnt;
    }

}
