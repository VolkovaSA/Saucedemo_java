package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCardPage extends BasePage {

    private static final String PRODUCT_DESCRIPTION = "//div[@data-test='inventory-item-desc']";

    public ProductCardPage(WebDriver driver) {
        super(driver);
    }

    public String checkDescription() {
        return driver.findElement(By.xpath(PRODUCT_DESCRIPTION)).getText();
    }
}
