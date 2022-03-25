package ui.functions;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import ui.ExerciseManagerApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AudioVisual extends Function {
    public static final String JPG = "./data/project_img1.jpg";
    public static final String WAV = "./data/project_audio.wav";
    private JFrame frame;
    private ImageIcon icon;
    private JLabel label;

    private AudioPlayer audioPlayer;
    private AudioStream audioStream;
    private InputStream inputStream;

    // EFFECTS: constructs AudioVisual function
    public AudioVisual(ExerciseManagerApp exerciseManagerApp, JComponent parent) {
        super(exerciseManagerApp, parent);
    }

    @Override
    // EFFECTS: creates the appropriate field for function
    protected void createFields(JComponent parent) {
        button = new JButton("Click Here!");
        button.setEnabled(true);
        addToParent(parent);
    }

    @Override
    // EFFECTS: creates listener
    protected void addListener() {
        button.addActionListener((new AudioVisualClickHandler()));
    }

    private class AudioVisualClickHandler implements ActionListener {

        @Override
        // EFFECTS: displays JPG and plays WAV
        public void actionPerformed(ActionEvent e) {
            image();
            music();
        }

        // EFFECTS: displays the image selected
        private void image() {
            frame = new JFrame();
            frame.setMinimumSize(new Dimension(400, 400));
            icon = new ImageIcon(JPG);
            label = new JLabel(icon);
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
        }

        // EFFECTS: plays the selected audio file
        public void music() {
            audioPlayer = AudioPlayer.player;
            ContinuousAudioDataStream loop = null;

            try {
                inputStream = new FileInputStream(WAV);
                audioStream = new AudioStream(inputStream);
                AudioPlayer.player.start(audioStream);

            } catch (IOException error) {
                System.out.print(error.toString());
            }
            audioPlayer.start(loop);
        }


    }
}
