package ui.functions;

import model.SessionsList;
import persistence.JsonWriter;
import ui.ExerciseManagerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SaveSession extends Function {
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonWriter jsonWriter;

    // EFFECTS: constructs SaveSession function
    public SaveSession(ExerciseManagerApp exerciseManagerApp, JComponent parent) {
        super(exerciseManagerApp, parent);
    }

    @Override
    // EFFECTS: creates the appropriate field for function
    protected void createFields(JComponent parent) {
        button = new JButton("Save Sessions to File");
        button.setEnabled(true);
        addToParent(parent);
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    @Override
    // EFFECTS: creates listener
    protected void addListener() {
        button.addActionListener((new SaveSessionClickHandler()));
    }

    // class for the click handler
    private class SaveSessionClickHandler implements ActionListener {
        SessionsList sessionsList = exerciseManagerApp.getSessionsList();

        @Override
        // EFFECTS: implements actions
        public void actionPerformed(ActionEvent e) {
            try {
                jsonWriter.open();
                jsonWriter.write(sessionsList);
                jsonWriter.close();
                exerciseManagerApp.setText("Your Sessions have been saved to " + JSON_STORE);
            } catch (FileNotFoundException f) {
                exerciseManagerApp.setText("Unable to write to file: " + JSON_STORE);
            }
        }
    }
}
