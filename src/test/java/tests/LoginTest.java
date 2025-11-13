package tests;

import org.testng.annotations.Test;
import pages.ProductCardPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка корректного логина")
    public void userName() {
        loginPage.open();
        loginPage.login("standard_user");
        assertTrue(productsPage.checkProductsTitle(), "Ожидалось наличие заголовка 'Products'");
    }

    @Test(description = "Проверка некорректного логина 'locked_out_user'")
    public void lockedOutUser() {
        loginPage.open();
        loginPage.login("locked_out_user");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "Проверка некорректного логина 'problem_user'")
    public void problemUser() {
        loginPage.open();
        loginPage.login("problem_user");
        assertEquals(productsPage.checkImage("Sauce Labs Backpack"), "https://www.saucedemo.com/static/media/sl-404.168b1cce10384b857a6f.jpg");
    }

    @Test(description = "Проверка некорректного логина 'performance_glitch_user'")
    public void glitchUser() {
        loginPage.open();
        loginPage.login("performance_glitch_user");
        assertTrue(productsPage.checkProductsTitle(), "Ожидалось наличие заголовка 'Products'");
    }

    @Test(description = "Проверка некорректного логина 'error_user'")
    public void errorUser() throws InterruptedException {
        loginPage.open();
        loginPage.login("error_user");
        productsPage.openProductCard("Sauce Labs Bike Light");
        assertEquals(productCardPage.checkDescription(), "A description should be here, but it failed to render! This error has been reported to Backtrace.");
    }


}
