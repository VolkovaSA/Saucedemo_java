package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AddToCartTest extends BaseTest {
    private static final String BACKPACK = "Sauce Labs Backpack";
    private static final String ONESIE = "Sauce Labs Onesie";
    private static final String FLEECE_JACKET = "Sauce Labs Fleece Jacket";


    @Test(description = "Проверка добавления товара в корзину")
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.addToCart(BACKPACK), "1");
    }

    @Test(description = "Проверка добавления товара в корзину", priority = 3)
    public void checkProductsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpen();
        productsPage.addToCart(3);
        productsPage.addToCart(ONESIE);
        productsPage.openCart();
        cartPage.waitPageLoaded();
        assertTrue(cartPage.getProductsNames().contains(FLEECE_JACKET));
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 2);
    }
}
