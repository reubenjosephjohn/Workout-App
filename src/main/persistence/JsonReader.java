package persistence;

import model.Exercise;
import model.Session;
import model.SessionsList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads sessionsList from JSON data stored in file
// Reference: All methods in this class are based on the JsonReader class from JsonSerializationDemo
// (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads sessionsList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public SessionsList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSessionsList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses sessionsList from JSON object and returns it
    private SessionsList parseSessionsList(JSONObject jsonObject) {
        SessionsList sl = new SessionsList();
        addSessions(sl, jsonObject);
        return sl;
    }

    // MODIFIES: sl
    // EFFECTS: parses thingies from JSON object and adds them to sessionsList
    private void addSessions(SessionsList sl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("List of Sessions");
        for (Object json : jsonArray) {
            JSONObject nextSession = (JSONObject) json;
            addSession(sl, nextSession);
        }
    }

    // MODIFIES: sl
    // EFFECTS: parses Session from JSON object and adds it to sessionsList
    private void addSession(SessionsList sl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Session session = new Session(name);
        addExercises(session, jsonObject);
        sl.addSession(session);
    }

    // MODIFIES: s
    // EFFECTS: parses Exercises from JSON object and adds it to session
    private void addExercises(Session s, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addExercise(s, nextExercise);
        }
    }

    // MODIFIES: s
    // EFFECTS: parses Exercise from JSON object and adds it to session
    private void addExercise(Session s, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int sets = jsonObject.getInt("sets");
        int reps = jsonObject.getInt("reps");
        int duration = jsonObject.getInt("duration");
        int caloriesBurnt = jsonObject.getInt("caloriesBurnt");
        Exercise exercise = new Exercise(name, sets, reps, duration,caloriesBurnt);
        s.addExercise(exercise);
    }


}


