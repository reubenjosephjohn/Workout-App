package ui.functions;

import ui.ExerciseManagerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// SOURCE: Code in this class is modelled based on
// (https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git)

public class ViewSessions extends Function {
    // EFFECTS: constructs ViewSessions function
    public ViewSessions(ExerciseManagerApp exerciseManagerApp, JComponent parent) {
        super(exerciseManagerApp, parent);
    }

    @Override
    // EFFECTS: creates the appropriate field for function
    protected void createFields(JComponent parent) {
        button = new JButton("View all sessions:");
        button.setEnabled(true);
        addToParent(parent);

    }

    @Override
    // EFFECTS: creates listener
    protected void addListener() {
        button.addActionListener(new ViewSessionsClickHandler());
    }

    // class for the click handler
    private class ViewSessionsClickHandler implements ActionListener {

        @Override
        // EFFECTS: implements actions
        public void actionPerformed(ActionEvent e) {
            exerciseManagerApp.setAllSessionsDisplay();

        }
    }
}
