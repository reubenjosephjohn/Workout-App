package ui.functions;

import ui.ExerciseManagerApp;

import javax.swing.*;

// SOURCE: Code in this class is modelled based on
// (https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git)
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

    // EFFECTS: creates field for function
    protected abstract void createFields(JComponent parent);

    // MODIFIES: parent
    // EFFECTS:  adds given button to the parent component
    public void addToParent(JComponent parent) {
        parent.add(button);
    }

    // EFFECTS: adds listener for this function
    protected abstract void addListener();
}
