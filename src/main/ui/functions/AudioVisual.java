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

// SOURCE: Code in this class is modelled based on
// (https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git)
// (https://stackoverflow.com/questions/20811728/adding-music-sound-to-java-programs) for the audio
// (https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel) for the image

public class AudioVisual extends Function {
    // SOURCE: (https://cdn-0.therandomvibez.com/wp-content/uploads/2019/09/Quotes-About-Grinding-And-Hustling.jpg)
    public static final String JPG = "./data/project_img.jpg";
    // SOURCE: (https://www.youtube.com/watch?v=w1PRiHEHJd8)
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
    // EFFECTS: creates appropriate field for function
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
        // EFFECTS: displays image and plays audio
        public void actionPerformed(ActionEvent e) {
            image();
            audio();
        }

        // EFFECTS: plays the selected audio file
        public void audio() {
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

        // EFFECTS: displays the image selected
        private void image() {
            frame = new JFrame();
            frame.setMinimumSize(new Dimension(600, 600));
            icon = new ImageIcon(JPG);
            label = new JLabel(icon);
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
        }

    }
}
