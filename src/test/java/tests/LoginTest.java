package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.ProductsPage.PROBLEM_IMG;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка корректного логина")
    public void correctUserName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpen(), "Ожидалось наличие заголовка 'Products'");
    }

    @DataProvider(name = "invalidUser")
    public Object[][] loginData() {
        return new Object[][] {
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(dataProvider = "invalidUser")
    public void incorrectLogin(String username, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(username, password);
        assertEquals(loginPage.checkErrorMsg(), errorMessage);
    }

    @Test(description = "Проверка некорректного логина 'problem_user'")
    public void problemUser() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
        assertEquals(productsPage.checkImage("Sauce Labs Backpack"), PROBLEM_IMG);
    }

    @Test(description = "Проверка некорректного логина 'performance_glitch_user'")
    public void glitchUser() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        assertTrue(productsPage.isPageOpen(), "Ожидалось наличие заголовка 'Products'");
    }

    @Test(description = "Проверка некорректного логина 'error_user'")
    public void errorUser() throws InterruptedException {
        loginPage.open();
        loginPage.login("error_user", "secret_sauce");
        productsPage.openProductCard("Sauce Labs Bike Light");
        assertEquals(productCardPage.checkDescription(), "A description should be here, but it failed to render! This error has been reported to Backtrace.");
    }
}
