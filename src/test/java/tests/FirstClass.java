package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstClass extends BaseTest {

    @Test
    public void userName() {
        loginPage.open();
        loginPage.login("standard_user");
        productsPage.checkProductsTitle();
        assertTrue(productsPage.checkProductsTitle(), "Ожидалось наличие заголовка 'Products'");
    }

    @Test
    public void wrongUserName() {
        loginPage.open();
        loginPage.login("locked_out_user");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
