package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private static final By PRODUCTS_TITLE = By.xpath("//span[contains(text(),'Products')]");
    private static final By CART_BADGE = By.xpath("//*[@data-test='shopping-cart-badge']");
    private static final String PRODUCT_IMG = "//img[@alt='%s']";
    private static final String PRODUCT_NAME = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::div[@data-test='inventory-item-name']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkProductsTitle() {
        return driver.findElement(PRODUCTS_TITLE).isDisplayed();
    }

    public String addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
        return driver.findElement(CART_BADGE).getText();
    }

    public String checkImage(final String goodsName) {
        By checkImage = By.xpath(PRODUCT_IMG.formatted(goodsName));
        return driver.findElement(checkImage).getAttribute("src");
    }

    public void openProductCard(final String goodsName) {
        By openProductCard = By.xpath(PRODUCT_NAME.formatted(goodsName));
        driver.findElement(openProductCard).click();
    }
}

