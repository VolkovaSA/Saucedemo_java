package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddToCartTest extends BaseTest {

    @Test(description = "Проверка добавления товара в корзину", priority = 3)
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user");
        assertEquals(productsPage.addToCart("Sauce Labs Backpack"), "1");
    }
}
