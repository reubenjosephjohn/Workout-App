package ui.functions;

import ui.ExerciseManagerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

// SOURCE: Code in this class is modelled based on
// (https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git)
public class ViewDetails extends Function {
    private JLabel name;
    private JTextField textField;

    // EFFECTS: constructs ViewDetails function
    public ViewDetails(ExerciseManagerApp exerciseManagerApp, JComponent parent) {
        super(exerciseManagerApp, parent);
    }

    @Override
    // EFFECTS: creates the appropriate field for function
    protected void createFields(JComponent parent) {

        name = new JLabel("View session: ");
        parent.add(name);

        textField = new JTextField(0);
        parent.add(textField);

        button = new JButton("View details of a particular session:");
        button.setEnabled(true);
        addToParent(parent);

    }

    @Override
    // EFFECTS: creates listener
    protected void addListener() {
        button.addActionListener((new ViewDetailsClickHandler()));
    }

    private class ViewDetailsClickHandler implements ActionListener {

        @Override
        // EFFECTS: implements actions
        public void actionPerformed(ActionEvent e) {
            int number = parseInt(textField.getText());
            exerciseManagerApp.viewDetails(number);
            textField.setText(null);

        }
    }
}
