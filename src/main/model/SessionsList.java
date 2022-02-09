package model;

import java.util.ArrayList;

// Represents a list of sessions
public class SessionsList {
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
    public ArrayList<Session> getSessionsList() {
        return sessionsList;
    }
}
