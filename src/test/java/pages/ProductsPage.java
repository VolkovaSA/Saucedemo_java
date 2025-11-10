package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    WebDriver browser;

    private static final By PRODUCTS_TITLE = By.xpath("//span[contains(text(),'Products')]");

    public ProductsPage(WebDriver browser) {
        this.browser = browser;
    }

    public boolean checkProductsTitle() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_TITLE));
        return browser.findElement(PRODUCTS_TITLE).isDisplayed();
    }
}
