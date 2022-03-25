package ui.functions;

import model.SessionsList;
import persistence.JsonReader;
import ui.ExerciseManagerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// SOURCE: Code in this class is modelled based on
// (https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git)
public class LoadSession extends Function {
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/workroom.json";
    private ExerciseManagerApp exerciseManagerApp;

    // EFFECTS: constructs LoadSession function
    public LoadSession(ExerciseManagerApp exerciseManagerApp, JComponent parent) {
        super(exerciseManagerApp, parent);
        this.exerciseManagerApp = exerciseManagerApp;
    }

    @Override
    // EFFECTS: creates field for function
    protected void createFields(JComponent parent) {
        button = new JButton("Load Sessions from File");
        button.setEnabled(true);
        addToParent(parent);
        jsonReader = new JsonReader(JSON_STORE);
    }

    @Override
    // EFFECTS: creates listener
    protected void addListener() {
        button.addActionListener((new LoadSessionClickHandler()));
    }

    private class LoadSessionClickHandler implements ActionListener {

        @Override
        // EFFECTS: implements action
        public void actionPerformed(ActionEvent e) {
            try {
                SessionsList sessionsList = jsonReader.read();
                exerciseManagerApp.setSessions(sessionsList);
                exerciseManagerApp.setText("Loaded your sessions from " + JSON_STORE);

            } catch (IOException f) {
                exerciseManagerApp.setText("Unable to read from file: " + JSON_STORE);
            }
        }
    }
}
