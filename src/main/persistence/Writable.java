package persistence;

import org.json.JSONObject;


// Reference: All methods in this class are based on the Writable interface from JsonSerializationDemo
// (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
