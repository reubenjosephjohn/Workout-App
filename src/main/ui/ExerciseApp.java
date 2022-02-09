package ui;

import model.Exercise;
import model.Session;
import model.SessionsList;

import java.util.Scanner;

public class ExerciseApp {
    private SessionsList sessionsList;
    private Scanner input;

    // EFFECTS: runs the exercise application
    public ExerciseApp() {
        runExerciseApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // inspired by TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
    // class: TellerApp, method: runTellerApp
    private void runExerciseApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");

    }

    // MODIFIES: this
    // EFFECTS: processes user command
    // inspired by TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
    // class: TellerApp, method: processCommand
    private void processCommand(String command) {
        if (command.equals("v")) {
            viewSession();
        } else if (command.equals("c")) {
            createNewSession();
        } else if (command.equals("a")) {
            addExercise();
        } else if (command.equals("i")) {
            viewSessionInfo();
        } else {
            System.out.println("Selection not valid...");
        }


    }

    // MODIFIES: this
    // EFFECTS: initializes sessionsList
    // inspired by TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
    // class: TellerApp, method: init
    private void init() {
        sessionsList = new SessionsList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays the list of sessions to user
    // inspired by TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
    // class: TellerApp, method: displayMenu
    private void displayMenu() {
        System.out.println("\nSelect From:");
        System.out.println("\tv -> View Sessions");
        System.out.println("\tc -> Create New Session");
        System.out.println("\ta -> Add Exercise to Session");
        System.out.println("\ti -> Get Session Info");
        System.out.println("\tq -> Quit");
    }

    // EFFECTS: displays numbered list of session names, or if none, it displays "You have no sessions"
    private void viewSession() {
        if (sessionsList.getLength() == 0) {
            System.out.println("You have no sessions.");
        }
        for (int i = 0; i < sessionsList.getLength(); i++) {
            System.out.println((i + 1) + " -> " + sessionsList.getSessionsList().get(i).getSessionName());

        }
    }

    // MODIFIES: this
    // EFFECTS: creates a new Session and adds it to sessionsList
    private void createNewSession() {
        System.out.println("Name of Session:");
        input.nextLine();
        String name = input.nextLine();
        Session newSession = new Session(name);
        sessionsList.addSession(newSession);
    }

    // MODIFIES: this
    // EFFECTS: adds exercise to the selected session
    private void addExercise() {
        if (sessionsList.getLength() == 0) {
            System.out.println("You have no sessions.");
        } else {
            System.out.println("Select Session Number:");
            int num = input.nextInt();
            Session s1 = sessionsList.getSessionsList().get(num - 1);
            System.out.println("Selected:" + s1.getSessionName());
            System.out.println("Name of Exercise:");
            input.nextLine();
            String name = input.nextLine();
            System.out.println("Number of Sets:");
            int sets = input.nextInt();
            System.out.println("Number of Reps:");
            int reps = input.nextInt();
            System.out.println("Duration:");
            int duration = input.nextInt();
            System.out.println("Number of Calories Burnt");
            int caloriesburnt = input.nextInt();
            Exercise e1 = new Exercise(name, sets, reps, duration,caloriesburnt);
            s1.addExercise(e1);
            System.out.println("Exercise has been added.");
        }
    }

    // EFFECTS: prints out information of the exercises in a session
    private void viewSessionInfo() {
        System.out.println("Which session would you like to view? (Enter valid number):");
        int num = input.nextInt() - 1;
        Session s1 = sessionsList.getSessionsList().get(num);
        if (s1.getLength() == 0) {
            System.out.println("There are no exercises in this workout.");
        } else {
            for (int i = 0; i < s1.getLength(); i++) {
                System.out.println((i + 1) + ")");
                System.out.println("Name: " + s1.getExercises().get(i).getExerciseName());
                System.out.println("Sets: " + (s1.getExercises().get(i).getExerciseSets()));
                System.out.println("Reps: " + (s1.getExercises().get(i).getExerciseReps()));
                System.out.println("Duration: " + (s1.getExercises().get(i).getExerciseDuration()));
                System.out.println("Calories Burnt: " + (s1.getExercises().get(i).getCaloriesBurnt()));

            }
        }
    }
}
