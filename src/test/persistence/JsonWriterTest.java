package persistence;

import model.Exercise;
import model.Session;
import model.SessionsList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            SessionsList sl = new SessionsList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptySessionsList() {
        try {
            SessionsList sl = new SessionsList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptySessionsList.json");
            writer.open();
            writer.write(sl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptySessionsList.json");
            sl = reader.read();
            assertEquals(0, sl.getLength());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralSessionsList() {
        try {
            SessionsList sl = new SessionsList();
            Session s1 = new Session("Back");
            s1.addExercise(new Exercise("squats", 3, 3, 60, 45));
            s1.addExercise(new Exercise("dead-lift", 4, 10, 100, 80));
            Session s2 = new Session("Chest");
            s2.addExercise(new Exercise("push-ups",3, 5, 60, 60));
            sl.addSession(s1);
            sl.addSession(s2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralSessionsList.json");
            writer.open();
            writer.write(sl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralSessionsList.json");
            sl = reader.read();
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
            fail("Exception should not have been thrown");
        }
    }

}
