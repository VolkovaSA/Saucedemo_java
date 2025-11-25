package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class AddToCartTest extends BaseTest {
    private static final String BACKPACK = "Sauce Labs Backpack";
    private static final String ONESIE = "Sauce Labs Onesie";
    private static final String FLEECE_JACKET = "Sauce Labs Fleece Jacket";

    @Test(description = "Проверка добавления товара в корзину")
    public void checkGoodsAdded() {
        System.out.println("CheckGoodsAdded Tests are running in:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(productsPage.addToCart(BACKPACK), "1");
    }

    @Test(description = "Проверка добавления товара в корзину", priority = 3)
    public void checkProductsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());
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
