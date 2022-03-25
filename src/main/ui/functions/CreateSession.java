package ui.functions;

import ui.ExerciseManagerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateSession extends Function {
    private JLabel name;
    private JTextField textField;

    // EFFECTS: constructs function
    public CreateSession(ExerciseManagerApp exerciseManagerApp, JComponent parent) {
        super(exerciseManagerApp, parent);
    }

    // EFFECTS: creates the appropriate field for function
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

    // class for the click handler
    private class CreateSessionClickHandler implements ActionListener {

        @Override
        // EFFECTS: implements actions
        public void actionPerformed(ActionEvent e) {
            String name = textField.getText();
            exerciseManagerApp.addSession(name);
            textField.setText(null);

        }
    }
}
