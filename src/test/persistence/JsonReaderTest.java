package persistence;

import model.Exercise;
import model.Session;
import model.SessionsList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            SessionsList sl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptySessionsList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptySessionsList.json");
        try {
            SessionsList sl = reader.read();
            assertEquals(0, sl.getLength());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralSessionsList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralSessionsList.json");
        try {
            SessionsList sl = reader.read();
            List<Session> sessions = sl.getSessions();
            assertEquals(2, sessions.size());
            checkSession("Back", 2, sessions.get(0));
            List<Exercise> exc1 = sessions.get(0).getExercises();
            checkExercise("squats", 3, 3, 60, 45,  exc1.get(0));
            checkExercise("dead-lift", 4, 10, 100, 80,
                    exc1.get(1));
            List<Exercise> exc2 = sessions.get(1).getExercises();
            checkSession("Chest", 1, sessions.get(1));
            checkExercise("push-ups",3, 5, 60, 60, exc2. get(0));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
