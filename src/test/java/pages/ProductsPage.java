package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private static final By PRODUCTS_TITLE = By.xpath("//span[contains(text(),'Products')]");
    private static final By CART_BADGE = By.xpath("//*[@data-test='shopping-cart-badge']");
    private static final String PRODUCT_IMG = "//img[@alt='%s']";
    private static final String PRODUCT_NAME = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::div[@data-test='inventory-item-name']";
    public static final String PROBLEM_IMG = "https://www.saucedemo.com/static/media/sl-404.168b1cce10384b857a6f.jpg";
    public static final By CART = By.cssSelector(".shopping_cart_link");
    private static final By ADD_TO_CART_BTN = By.xpath("//*[text()='Add to cart']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидаем прогрузки страницы с товарами")
    public boolean isPageOpen() {
        return driver.findElement(PRODUCTS_TITLE).isDisplayed();
    }

    @Step("Получаем значение счетчика товаров в корзине")
    public String addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
        return driver.findElement(CART_BADGE).getText();
    }

    @Step("Добавляем товар в корзину")
    public void addToCart(final int index) {
        driver.findElements(ADD_TO_CART_BTN).get(index).click();
    }

    @Step("Получаем src картики товара")
    public String checkImage(final String goodsName) {
        By checkImage = By.xpath(PRODUCT_IMG.formatted(goodsName));
        return driver.findElement(checkImage).getAttribute("src");
    }

    @Step("Открываем карточку товара")
    public void openProductCard(final String goodsName) {
        By openProductCard = By.xpath(PRODUCT_NAME.formatted(goodsName));
        driver.findElement(openProductCard).click();
    }

    @Step("Открываем корзину")
    public void openCart() {
        driver.findElement(CART).click();
    }
}
