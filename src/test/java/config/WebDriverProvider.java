package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverProvider {
    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    public WebDriver get() {
        return createDriver();
    }

    private WebDriver createDriver() {
        if (config.runRemote()) {
            return createRemoteDriver();
        } else {
            return createLocalDriver();
        }
    }

    private WebDriver createLocalDriver() {
        switch (config.getBrowser()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions());
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(new FirefoxOptions());
            default:
                throw new RuntimeException("No such driver");
        }
    }

    private WebDriver createRemoteDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(config.getBrowser().toString().toLowerCase());
        capabilities.setVersion(config.getBrowserVersion());
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        return new RemoteWebDriver(config.getRemoteURL(), capabilities);
    }
}
