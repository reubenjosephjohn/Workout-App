package ui;

import model.Exercise;
import model.Session;
import model.SessionsList;
import ui.functions.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

// SOURCE: Code in this class is modelled based on
// (https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git) - structure
// (https://stackoverflow.com/questions/50949189/building-ui-with-java-swing)
// (https://docs.oracle.com/javase/tutorial/uiswing/index.html)
public class ExerciseManagerApp extends JFrame {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;

    private JLabel name;
    private List<Function> functions;
    private CreateSession createSession;
    private AddExercise addExercise;
    private ViewDetails viewDetails;
    private SaveSession saveSession;
    private LoadSession loadSession;
    private ViewSessions viewSessions;
    private AudioVisual audioVisual;

    private SessionsList sessionsList;
    private JPanel textPanel;
    private JPanel functionPanel;
    private JTextArea textArea;

    private Font textAreaFont;

    // EFFECTS: initiates all the fields and graphics for GUI
    public ExerciseManagerApp() {
        super("Sessions List");
        initializeFields();
        initializeGraphics();
    }

    // EFFECTS: initializes functions and sessionsList
    private void initializeFields() {
        functions = new ArrayList<>();
        sessionsList = new SessionsList();
    }

    // MODIFIES: this
    // EFFECTS: initializes functions and graphics for GUI
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        initializeFunctionPanel();
        initializeTextPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("ExerciseManagerApp");
        pack();
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: creates graphics, functions and adds them to functionPanel
    private void initializeFunctionPanel() {
        functionPanel = new JPanel();
        functionPanel.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));
        functionPanel.setLayout(new GridLayout(0,1));
        functionPanel.setSize(new Dimension(0, 0));
        add(functionPanel, BorderLayout.EAST);

        JPanel createSessionPanel = new JPanel();
        makeCreateSessionPanel(createSessionPanel);
        functionPanel.add(createSessionPanel);

        JPanel addExercisePanel = new JPanel();
        makeAddExercisePanel(addExercisePanel);
        functionPanel.add(addExercisePanel);

        JPanel viewPanel = new JPanel();
        makeViewPanel(viewPanel);
        functionPanel.add(viewPanel);

        JPanel saveLoadPanel = new JPanel();
        makeSaveLoadPanel(saveLoadPanel);
        functionPanel.add(saveLoadPanel);

        JPanel audioVisualPanel = new JPanel();
        makeAudioVisualPanel(audioVisualPanel);
        functionPanel.add(audioVisualPanel);
    }

    // MODIFIES: this
    // EFFECTS: creates panel for CreateSession function
    private void makeCreateSessionPanel(JPanel createSessionPanel) {
        createSessionPanel.setLayout(new GridLayout());
        createSessionPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(
                "Create a Session:"), BorderFactory.createEmptyBorder(20,15,20,15)));

        createSession = new CreateSession(this, createSessionPanel);
        functions.add(createSession);
    }

    // MODIFIES: this
    // EFFECTS: creates panel for ViewDetails function
    private void makeViewPanel(JPanel viewPanel) {
        viewPanel.setLayout(new GridLayout(2, 0));
        viewPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(
                "Change View:"), BorderFactory.createEmptyBorder(15,15,15,15)));

        viewDetails = new ViewDetails(this, viewPanel);
        functions.add(viewDetails);

        viewSessions = new ViewSessions(this, viewPanel);
        functions.add(viewSessions);
    }

    // MODIFIES: this
    // EFFECTS: creates panel for addExercise function
    private void makeAddExercisePanel(JPanel addExercisePanel) {
        addExercisePanel.setLayout(new GridLayout(4, 4));
        addExercisePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(
                "Create an Exercise:"), BorderFactory.createEmptyBorder(20,15,20,15)));

        addExercise = new AddExercise(this, addExercisePanel);
        functions.add(addExercise);
    }

    // MODIFIES: this
    // EFFECTS: creates panel for AudioVisual Function
    private void makeAudioVisualPanel(JPanel audioVisualPanel) {
        audioVisualPanel.setLayout(new GridLayout());
        audioVisualPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(
                        "Click here if you've completed your session!!"),
                BorderFactory.createEmptyBorder(15,15,15,15)));

        audioVisual = new AudioVisual(this, audioVisualPanel);
        functions.add(audioVisual);
    }

    // MODIFIES: this
    // EFFECTS: creates panel for Save and Load functions
    private void makeSaveLoadPanel(JPanel saveLoadPanel) {
        saveLoadPanel.setLayout(new GridLayout(2, 0));
        saveLoadPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(
                "Save or load file:"), BorderFactory.createEmptyBorder(15,15,15,15)));

        loadSession = new LoadSession(this, saveLoadPanel);
        functions.add(loadSession);

        saveSession = new SaveSession(this, saveLoadPanel);
        functions.add(loadSession);
    }

    // MODIFIES: this
    // EFFECTS: initializes text panel
    private void initializeTextPanel() {
        textPanel = new JPanel();

        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        textPanel.setLayout(new GridLayout(1,0));
        textPanel.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));

        add(textPanel, BorderLayout.WEST);
        textPanel.setBackground(new Color(0x0000FF));

        textAreaFont = new Font("Montserrat", Font.BOLD, 20);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(textAreaFont);
        textPanel.add(textArea);

        textArea.setText("Welcome to the your Personal Exercise Manager!");

    }

    // REQUIRES: Strings for sets, reps, caloriesBurnt, and duration are natural numbers and
    // number is Natural number that <= the highest session number
    // MODIFIES: sessionsList, this
    // EFFECTS: adds an exercise to selected session, and sets the textArea to display the details of that session
    public void addExercise(String name, String sets, String reps, String caloriesBurnt, String duration,
                            String number) {
        int number1 = parseInt(number);
        Session s1 = sessionsList.getSessions().get(number1 - 1);
        s1.addExercise(new Exercise(name, parseInt(sets), parseInt(reps), parseInt(caloriesBurnt), parseInt(duration)));
        viewDetails(number1);
    }

    // MODIFIES: sessionsList, this
    // EFFECTS: adds session to sessionsList and sets display to all sessions
    public void addSession(String name) {
        Session s = new Session(name);
        sessionsList.addSession(s);
        setAllSessionsDisplay();
    }

    // MODIFIES: this, textArea
    // EFFECTS: sets the textPanel to display a list of all the sessions
    public void setAllSessionsDisplay() {
        if (sessionsList.getLength() == 0) {
            textArea.setText("You have no sessions.");
        }
        textArea.setText("Your list of sessions: \n\n");
        for (int i = 0; i < sessionsList.getLength(); i++) {
            String s = textArea.getText();
            textArea.setText(s + (i + 1) + ") " + sessionsList.getSessions().get(i).getSessionName() + "\r\n");
        }
    }



    // EFFECTS: returns sessionsList
    public SessionsList getSessionsList() {
        return sessionsList;
    }

    // REQUIRES: number <= the total amount of sessions
    // MODIFIES: this
    // EFFECTS: sets display to view the session of given number
    public void viewDetails(int number) {
        int num = number - 1;
        Session s1 = sessionsList.getSessions().get(num);
        if (s1.getLength() == 0) {
            textArea.setText("There are no exercises in this session.");
        } else {
            textArea.setText(number + ") " + s1.getSessionName() + ":\n\n");
            for (int i = 0; i < s1.getLength(); i++) {
                String s = textArea.getText();

                String sessionNumber = ((i + 1) + ". ");
                String name = (s1.getExercises().get(i).getExerciseName() + "\n");
                String sets = (" --- Sets: " + (s1.getExercises().get(i).getExerciseSets()) + "\n");
                String reps = (" --- Reps: " + (s1.getExercises().get(i).getExerciseReps()) + "\n");
                String caloriesBurnt = (" --- Calories Burnt: " + (s1.getExercises().get(i).getCaloriesBurnt()) + "\n");
                String duration = (" --- Duration: " + (s1.getExercises().get(i).getExerciseDuration()) + "\n");

                textArea.setText(s + sessionNumber + name + sets + reps + caloriesBurnt + duration + "\n");
            }
        }
    }

    // MODIFIES: textArea, this
    // EFFECTS: sets the textArea to given string
    public void setText(String s) {
        textArea.setText(s);
    }

    // MODIFIES: sessionsList, this
    // EFFECTS: sets sessionsList to given low
    public void setSessions(SessionsList sl) {
        sessionsList = sl;
    }

}



//    private static final String JSON_STORE = "./data/sessionsList.json";
//    private SessionsList sessionsList;
//    private Scanner input;
//    private JsonWriter jsonWriter;
//    private JsonReader jsonReader;
//
//
//
//
//    //EFFECTS: runs the exercise application
//    public ExerciseManagerApp() {
//        runExerciseApp();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user input
//    // inspired by TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
//    // class: TellerApp, method: runTellerApp
//    private void runExerciseApp() {
//        boolean keepGoing = true;
//        String command = null;
//
//        init();
//
//        while (keepGoing) {
//            displayMenu();
//            command = input.next();
//            command = command.toLowerCase();
//
//            if (command.equals("q")) {
//                keepGoing = false;
//            } else {
//                processCommand(command);
//            }
//        }
//        System.out.println("\nGoodbye!");
//
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user command
//    // inspired by TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
//    // class: TellerApp, method: processCommand
//    private void processCommand(String command) {
//        if (command.equals("v")) {
//            viewSession();
//        } else if (command.equals("c")) {
//            createNewSession();
//        } else if (command.equals("a")) {
//            addExercise();
//        } else if (command.equals("i")) {
//            viewSessionInfo();
//        } else if (command.equals("s")) {
//            saveSessionsList();
//        } else if (command.equals("l")) {
//            loadSessionsList();
//        } else {
//            System.out.println("Selection not valid...");
//        }
//
//
//    }
//
//    // MODIFIES: this
//    // EFFECTS: initializes sessionsList
//    // inspired by TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
//    // class: TellerApp, method: init
//    private void init() {
//        sessionsList = new SessionsList();
//        input = new Scanner(System.in);
//        input.useDelimiter("\n");
//        jsonWriter = new JsonWriter(JSON_STORE);
//        jsonReader = new JsonReader(JSON_STORE);
//    }
//
//
//    // EFFECTS: displays the list of sessions to user
//    // inspired by TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
//    // class: TellerApp, method: displayMenu
//    private void displayMenu() {
//        System.out.println("\nSelect From:");
//        System.out.println("\tv -> View Sessions");
//        System.out.println("\tc -> Create New Session");
//        System.out.println("\ta -> Add Exercise to Session");
//        System.out.println("\ti -> Get Session Info");
//        System.out.println("\ts -> Save Session List to File");
//        System.out.println("\tl -> Load Session List from File");
//        System.out.println("\tq -> Quit");
//    }
//
//    // EFFECTS: displays numbered list of session names, or "You have no sessions" if none
//    private void viewSession() {
//        if (sessionsList.getLength() == 0) {
//            System.out.println("You have no sessions.");
//        }
//        for (int i = 0; i < sessionsList.getLength(); i++) {
//            System.out.println((i + 1) + " -> " + sessionsList.getSessions().get(i).getSessionName());
//
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: creates a new Session and adds it to sessionsList
//    private void createNewSession() {
//        System.out.println("Name of Session:");
//        input.nextLine();
//        String name = input.nextLine();
//        Session newSession = new Session(name);
//        sessionsList.addSession(newSession);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: adds exercise to the selected session
//    private void addExercise() {
//        if (sessionsList.getLength() == 0) {
//            System.out.println("You have no sessions.");
//        } else {
//            System.out.println("Select Session Number:");
//            int num = input.nextInt();
//            Session s1 = sessionsList.getSessions().get(num - 1);
//            System.out.println("Selected:" + s1.getSessionName());
//            System.out.println("Name of Exercise:");
//            input.nextLine();
//            String name = input.nextLine();
//            System.out.println("Number of Sets:");
//            int sets = input.nextInt();
//            System.out.println("Number of Reps:");
//            int reps = input.nextInt();
//            System.out.println("Duration: (in seconds)");
//            int duration = input.nextInt();
//            System.out.println("Number of Calories Burnt");
//            int caloriesburnt = input.nextInt();
//            Exercise e1 = new Exercise(name, sets, reps, duration, caloriesburnt);
//            s1.addExercise(e1);
//            System.out.println("Exercise has been added.");
//        }
//    }
//
//    // EFFECTS: prints out information of the exercises in a session
//    private void viewSessionInfo() {
//        System.out.println("Which session would you like to view? (Enter valid number):");
//        int num = input.nextInt() - 1;
//        Session s1 = sessionsList.getSessions().get(num);
//        if (s1.getLength() == 0) {
//            System.out.println("There are no exercises in this session.");
//        } else {
//            for (int i = 0; i < s1.getLength(); i++) {
//                System.out.println((i + 1) + ")");
//                System.out.println("Name: " + s1.getExercises().get(i).getExerciseName());
//                System.out.println("Sets: " + (s1.getExercises().get(i).getExerciseSets()));
//                System.out.println("Reps: " + (s1.getExercises().get(i).getExerciseReps()));
//                System.out.println("Duration: (in seconds)" + (s1.getExercises().get(i).getExerciseDuration()));
//                System.out.println("Calories Burnt: " + (s1.getExercises().get(i).getCaloriesBurnt()));
//
//            }
//        }
//    }
//
//    // EFFECTS: saves the sessionsList to file
//    // Reference: (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
//    private void saveSessionsList() {
//        try {
//            jsonWriter.open();
//            jsonWriter.write(sessionsList);
//            jsonWriter.close();
//            System.out.println("Your sessions are Saved to " + JSON_STORE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write to file: " + JSON_STORE);
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads sessionsList from file
//    // Reference: (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
//    private void loadSessionsList() {
//        try {
//            sessionsList = jsonReader.read();
//            System.out.println("Your Sessions are Loaded from "  + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//        }
//    }
//
//
//}
