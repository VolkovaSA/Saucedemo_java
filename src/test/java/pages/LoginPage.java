package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver browser;

    private static final By USER_NAME = By.cssSelector("#user-name");
    private static final By PASSWORD = By.cssSelector("#password");
    private static final By LOGIN_BTN = By.xpath("//input[@value='Login']");
    private static final By ERROR_MSG = By.xpath("//h3[@data-test]");

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void open() {
        browser.get("https://www.saucedemo.com");
    }

    public void login(String userName) {
        browser.findElement(USER_NAME).sendKeys(userName);
        browser.findElement(PASSWORD).sendKeys("secret_sauce");
        browser.findElement(LOGIN_BTN).click();
    }

    public String checkErrorMsg() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MSG));
        return browser.findElement(ERROR_MSG).getText();
    }
}
