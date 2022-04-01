package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class Session implements Writable {
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
        EventLog.getInstance().logEvent(new Event(e.getExerciseName()
                + " has been added to " + sessionName + "."));
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

    // Referred to (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", sessionName);
        json.put("exercises", exercisesToJson());
        return json;
    }

    // EFFECTS: returns exercises in this sessionsList as a JSON array
    private JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Exercise exc : exercisesList) {
            jsonArray.put(exc.toJson());
        }

        return jsonArray;
    }


}
