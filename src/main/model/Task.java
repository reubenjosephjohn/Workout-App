package model;

public class Task {
    private String taskDay;
    private Exercise exercise;
    private String taskDescription;
    private Boolean taskFinished;

    // EFFECTS: constructs a task with its description, day it is due and the exercise
    public Task(String day, Exercise exercise, String description, Boolean finished) {
        this.taskDay = day;
        this.exercise = exercise;
        this.taskDescription = description;
        this.taskFinished = finished;
    }

    // EFFECTS: returns the day the task is due
    public String getTaskDay() {
        return taskDay;
    }

    // EFFECTS: returns name of the exercise
    public String getTaskExerciseName() {
        return exercise.getExerciseName();
    }

    // EFFECTS: returns the type of exercise
    public String getTaskExerciseType() {
        return exercise.getExerciseType();
    }

    // EFFECTS: returns the duration of the exercise
    public int getTaskExerciseDuration() {
        return exercise.getExerciseDuration();
    }

    // EFFECTS: returns the calories burnt during the duration of the exercise
    public int getTaskCaloriesBurnt() {
        return exercise.getCaloriesBurnt();
    }

    // EFFECTS: returns the description of the task
    public String getTaskDescription() {
        return taskDescription;
    }

    // EFFECTS: returns true if task is completed
    public Boolean getTaskFinished() {
        return taskFinished;
    }

    public void setFinished() {
        taskFinished = true;
    }



}


