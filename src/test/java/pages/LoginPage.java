package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final By USER_NAME = By.cssSelector("#user-name");
    private static final By PASSWORD = By.cssSelector("#password");
    private static final By LOGIN_BTN = By.xpath("//input[@value='Login']");
    private static final By ERROR_MSG = By.xpath("//h3[@data-test]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String userName, String password) {
        fillInLogin(userName);
        fillInPassword(password);
        pressLoginBtn();
    }

    public void fillInLogin(String userName) {
        driver.findElement(USER_NAME).sendKeys(userName);
    }

    public void fillInPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void pressLoginBtn() {
        driver.findElement(LOGIN_BTN).click();
    }

    public String checkErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MSG));
        return driver.findElement(ERROR_MSG).getText();
    }
}
