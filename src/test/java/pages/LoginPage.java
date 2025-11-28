package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

public class LoginPage extends BasePage {

    private static final By USER_NAME = By.cssSelector("#user-name");
    private static final By PASSWORD = By.cssSelector("#password");
    private static final By LOGIN_BTN = By.xpath("//input[@value='Login']");
    private static final By ERROR_MSG = By.xpath("//h3[@data-test]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие URL страницы")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step(" Вводим логин = {user.email}")
    public void login(User user) {
        fillInLogin(user.getEmail());
        fillInPassword(user.getPassword());
        pressLoginBtn();
    }

    @Step(" Вводим пароль = ******")
    public void fillInLogin(String userName) {
        driver.findElement(USER_NAME).sendKeys(userName);
    }

    public void fillInPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    @Step("Нажимаем кнопку 'Login'")
    public void pressLoginBtn() {
        driver.findElement(LOGIN_BTN).click();
    }

    @Step("Проверяем текст сообщения об ошибке")
    public String checkErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MSG));
        return driver.findElement(ERROR_MSG).getText();
    }
}
