package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SessionsListTest {

    private SessionsList sessionsListTest;

    @BeforeEach
    public void setup() {
        sessionsListTest = new SessionsList();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, sessionsListTest.getLength());
    }

    @Test
    public void testAddSession() {
        Session s1 = new Session("Session 1");
        sessionsListTest.addSession(s1);
        assertEquals(1, sessionsListTest.getLength());
    }

    @Test
    public void testRemoveSessionOne() {
        Session s1 = new Session("Session 1");
        sessionsListTest.addSession(s1);
        assertEquals(1, sessionsListTest.getLength());
        sessionsListTest.removeSession("Session 1");
        assertEquals(0, sessionsListTest.getLength());
    }

    @Test
    public void testRemoveSessionMultiple() {
        Session s1 = new Session("Session 1");
        Session s2 = new Session("Session 2");
        Session s3 = new Session("Session 3");
        sessionsListTest.addSession(s1);
        sessionsListTest.addSession(s2);
        sessionsListTest.addSession(s3);
        assertEquals(3, sessionsListTest.getLength());
        sessionsListTest.removeSession("Session 1");
        sessionsListTest.removeSession("Session 3");
        assertEquals(1, sessionsListTest.getLength());
    }

    @Test
    public void testRemoveNoSession() {
        Session s1 = new Session("Session 1");
        sessionsListTest.addSession(s1);
        assertEquals(1, sessionsListTest.getLength());
        sessionsListTest.removeSession("session1");
        assertEquals(1, sessionsListTest.getLength());
    }

    @Test
    public void testGetSessions() {
        Session s1 = new Session("Session 1");
        Session s2 = new Session("Session 2");
        sessionsListTest.addSession(s1);
        sessionsListTest.addSession(s2);
        assertEquals(2, sessionsListTest.getSessionsList().size());
        assertEquals("Session 2", sessionsListTest.getSessionsList().get(1).getSessionName());
    }
}
