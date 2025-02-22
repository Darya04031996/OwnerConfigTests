package tests;

import config.WebDriverConfig;
import config.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Selenide;

public class BaseTest {
    private static final WebDriverConfig config =
            ConfigFactory.create(WebDriverConfig.class, System.getProperties());

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