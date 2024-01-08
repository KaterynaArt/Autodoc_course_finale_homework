package init;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import org.testng.annotations.BeforeTest;

public class InitialSelenide {

    @BeforeTest
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserSize = "3200х2000";
        options.addArguments("user-agent=" + getRandomUserAgent());
        Configuration.timeout = 10000;
        Configuration.browserCapabilities = options;
    }


    private static String getRandomUserAgent() {
        int value = (int) (Math.random() * UserAgent.values().length);
        List<UserAgent> userAgents = List.of(UserAgent.values());
        return userAgents.get(value).value;
    }

}