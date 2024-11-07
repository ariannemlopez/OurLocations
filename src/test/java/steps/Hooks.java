package steps;

import com.datacom.common.PageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks extends PageObject {
    public Hooks(WebDriver driver) {
        super(driver);
    }

    @Before
    public static void setup() {
        String browser = "chrome"; //temporary
        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> throw new RuntimeException(String.format("Unsupported browser: %s", browser));
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @After
    public static void tearDown() {
        driver.quit();
    }
}
