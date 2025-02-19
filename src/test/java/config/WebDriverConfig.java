package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:webdriver.properties")
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserVersion")
    @DefaultValue("latest")
    String getBrowserVersion();

    @Key("remoteUrl")
    @DefaultValue("http://localhost:4444/wd/hub")
    URL getRemoteURL();

    @Key("runRemote")
    @DefaultValue("false")
    boolean runRemote();
}
