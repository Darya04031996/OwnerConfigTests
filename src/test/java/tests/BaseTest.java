package tests;


import config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverProvider webDriverProvider = new WebDriverProvider();
        webDriverProvider.get();
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWebDriver();
    }
}