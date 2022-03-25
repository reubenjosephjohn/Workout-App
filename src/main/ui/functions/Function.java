package ui.functions;

import ui.ExerciseManagerApp;

import javax.swing.*;

public abstract class Function {
    protected JButton button;
    protected ExerciseManagerApp exerciseManagerApp;
    private boolean active;

    // EFFECTS: constructs functions
    public Function(ExerciseManagerApp exerciseManagerApp, JComponent parent) {
        this.exerciseManagerApp = exerciseManagerApp;
        createFields(parent);
        active = false;
        addListener();
    }

    // EFFECTS: creates the appropriate field for function
    protected abstract void createFields(JComponent parent);

    // EFFECTS: adds a listener for this function
    protected abstract void addListener();

    // MODIFIES: parent
    // EFFECTS:  adds the given button to the parent component
    public void addToParent(JComponent parent) {
        parent.add(button);
    }
}
