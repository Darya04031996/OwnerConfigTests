package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GitTest extends BaseTest {
    @Test
    public void testGithubTitle() {
        driver.get("https://github.com");
        assertEquals("GitHub: Let’s build from here · GitHub", driver.getTitle());
    }
}