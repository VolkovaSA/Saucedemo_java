package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By cartTitle = By.xpath("//*[@class='title']");
    private final By itemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getProductsNames() {
        List<WebElement> allProducts = driver.findElements(itemName);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProducts) {
            names.add(product.getText());
        }

        return names;
    }

    public void waitPageLoaded() {
        driver.findElement(cartTitle).isDisplayed();
    }
}
