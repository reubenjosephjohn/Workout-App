package model;

import java.util.ArrayList;

public class Session {
    private ArrayList<Exercise> exercisesList;
    private int timeTaken; // in seconds
    private String sessionName;

    // EFFECTS: constructs an empty session with time taken as 0
    public Session(String s) {
        exercisesList = new ArrayList<>();
        timeTaken = 0;
        sessionName = s;
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to the end of the session
    public void addExercise(Exercise e) {
        exercisesList.add(e);
    }

    // REQUIRES: length of s  is not 0
    // MODIFIES: this
    // EFFECTS: removes exercise with s as name
    public void removeExercise(String s) {
        exercisesList.removeIf(e -> (s.equals(e.getExerciseName())));

    }

    // REQUIRES: time is >= 0
    // EFFECTS: adds time to timeTaken
    public void addTime(int time) {
        timeTaken = timeTaken + time;
    }

    // REQUIRES: time is >= 0
    // EFFECTS: set timeTaken to time
    public void setTime(int time) {
        timeTaken = time;
    }

    // REQUIRES: time is >= 0
    // EFFECTS: time is subtracted from timeTaken, set timeTaken to 0 if difference < 0
    public void removeTime(int time) {
        if (timeTaken - time < 0) {
            timeTaken = 0;
        } else {
            timeTaken = timeTaken - time;
        }
    }

    // EFFECTS: returns length of exerciseList
    public int getLength() {
        return exercisesList.size();
    }


    // EFFECTS: returns timeTaken
    public int getTimeTaken() {
        return timeTaken;
    }

    // MODIFIES: this
    // EFFECTS: changes sessionName to s
    public void setSessionName(String s) {
        sessionName = s;
    }

    // EFFECTS: returns sessionName
    public String getSessionName() {
        return sessionName;
    }

    // EFFECTS: returns exercisesList
    public ArrayList<Exercise> getExercises() {
        return exercisesList;
    }

}
