package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Represents a list of sessions
public class SessionsList implements Writable {
    ArrayList<Session> sessionsList;

    // EFFECTS: Constructs an empty sessionsList
    public SessionsList() {

        sessionsList = new ArrayList<>();
    }

    // REQUIRES: session must be there
    // MODIFIES: this
    // EFFECTS: Adds a given session to the list of sessions
    public void addSession(Session s) {

        sessionsList.add(s);
        EventLog.getInstance().logEvent(new Event(s.getSessionName()
                + " has been added to the List of Sessions."));
    }

    // REQUIRES: session must be in the sessionsList
    // MODIFIES: this
    // EFFECTS: Removes given session from the sessionsList
    public void removeSession(String s) {
        sessionsList.removeIf(w -> (s.equals(w.getSessionName())));
    }

    // EFFECTS: returns size of sessionsList
    public int getLength() {
        return sessionsList.size();
    }

    // EFFECTS: returns sessionsList
    public ArrayList<Session> getSessions() {
        return sessionsList;
    }

    // Referred to (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Sessions List", sessionsToJson());
        return json;
    }

    // EFFECTS: returns sessions in this sessionsList as a JSON array
    private JSONArray sessionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Session s : sessionsList) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }
}
