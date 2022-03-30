package ui;

import model.Event;
import model.EventLog;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new ExerciseManagerApp();

        // Prints Event logs on closing
        // SOURCE: https://stackoverflow.com/questions/5824049/running-a-method-when-closing-the-program
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                for (Event e : EventLog.getInstance()) {
                    System.out.println(e.toString() + "\n\n");
                }
            }
        }, "Shutdown-thread"));
    }
}
