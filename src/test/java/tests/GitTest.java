package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GitTest extends BaseTest {

    @Test
    public void testGithub() {
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
    }
}