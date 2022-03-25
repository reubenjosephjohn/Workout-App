package ui.functions;

import ui.ExerciseManagerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// SOURCE: Code in this class is modelled based on
// (https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git)
public class CreateSession extends Function {
    private JLabel name;
    private JTextField textField;

    // EFFECTS: constructs function
    public CreateSession(ExerciseManagerApp exerciseManagerApp, JComponent parent) {
        super(exerciseManagerApp, parent);
    }

    // EFFECTS: creates field for function
    @Override
    protected void createFields(JComponent parent) {
        name = new JLabel("Name: ");
        parent.add(name);

        textField = new JTextField(0);
        parent.add(textField);


        button = new JButton("Create Session");
        button.setEnabled(true);
        addToParent(parent);

    }

    @Override
    // EFFECTS: creates listener
    protected void addListener() {
        button.addActionListener((new CreateSessionClickHandler()));
    }

    private class CreateSessionClickHandler implements ActionListener {

        @Override
        // EFFECTS: implements action
        public void actionPerformed(ActionEvent e) {
            String name = textField.getText();
            exerciseManagerApp.addSession(name);
            textField.setText(null);

        }
    }
}
