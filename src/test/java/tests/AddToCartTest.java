package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AddToCartTest extends BaseTest {

    @Test(description = "Проверка добавления товара в корзину")
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.addToCart("Sauce Labs Backpack"), "1");
    }

    @Test(description = "Проверка добавления товара в корзину", priority = 3)
    public void checkProductsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpen();
        productsPage.addToCart(3);
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.openCart();
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Fleece Jacket"));
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 2);
    }
}
