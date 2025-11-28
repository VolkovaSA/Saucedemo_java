package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilis.PropertyReader;

import java.time.Duration;

public abstract class BasePage {
    public static final String BASE_URL = PropertyReader.getProperty("saucedemo.url");
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
}
