package ui.functions;

import ui.ExerciseManagerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// SOURCE: Code in this class is modelled based on
// (https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git)
public class AddExercise extends Function {
    private JTextField textFieldName;
    private JTextField textFieldSets;
    private JTextField textFieldReps;
    private JTextField textFieldCaloriesBurnt;
    private JTextField textFieldDuration;
    private JTextField textFieldNumber;
    private JLabel name;
    private JLabel sets;
    private JLabel reps;
    private JLabel caloriesBurnt;
    private JLabel duration;
    private JLabel number;


    // EFFECTS: constructor for addExercise
    public AddExercise(ExerciseManagerApp exerciseManagerApp, JComponent parent) {
        super(exerciseManagerApp, parent);

    }

    // EFFECTS: creates button and text field to select session
    public void sessionNumberField(JComponent parent) {
        number = new JLabel("Session number:");
        parent.add(number);
        textFieldNumber = new JTextField(0);
        parent.add(textFieldNumber);
    }

    // EFFECTS: creates the buttons and text field for exercise inputs
    public void setLabelsAndText(JComponent parent) {
        name = new JLabel("Name: ");
        parent.add(name);
        textFieldName = new JTextField(0);
        parent.add(textFieldName);
        sets = new JLabel("Number of sets: ");
        parent.add(sets);
        textFieldSets = new JTextField(0);
        parent.add(textFieldSets);
        reps = new JLabel("Number of reps: ");
        parent.add(reps);
        textFieldReps = new JTextField(0);
        parent.add(textFieldReps);
        caloriesBurnt = new JLabel("Calories Burnt: ");
        parent.add(caloriesBurnt);
        textFieldCaloriesBurnt = new JTextField(0);
        parent.add(textFieldCaloriesBurnt);
        duration = new JLabel("Duration: ");
        parent.add(duration);
        textFieldDuration = new JTextField(0);
        parent.add(textFieldDuration);
        sessionNumberField(parent);

    }


    @Override
    // EFFECTS: creates the appropriate field for function
    protected void createFields(JComponent parent) {
        setLabelsAndText(parent);
        button = new JButton("Add Exercise");
        button.setEnabled(true);
        addToParent(parent);
    }

    @Override
    // EFFECTS: creates listener
    protected void addListener() {
        button.addActionListener((new AddExerciseClickHandler()));
    }

    // class for the click handler
    private class AddExerciseClickHandler implements ActionListener {

        @Override
        // EFFECTS: implements actions
        public void actionPerformed(ActionEvent e) {
            String name = textFieldName.getText();
            String sets = textFieldSets.getText();
            String reps = textFieldReps.getText();
            String caloriesBurnt = textFieldCaloriesBurnt.getText();
            String duration = textFieldDuration.getText();
            String number = textFieldNumber.getText();
            exerciseManagerApp.addExercise(name, sets, reps, caloriesBurnt, duration, number);
            textFieldName.setText(null);
            textFieldSets.setText(null);
            textFieldReps.setText(null);
            textFieldCaloriesBurnt.setText(null);
            textFieldDuration.setText(null);
            textFieldNumber.setText(null);

        }
    }

}
