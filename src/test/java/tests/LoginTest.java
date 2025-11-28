package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static enums.DepartmentNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.ProductsPage.PROBLEM_IMG;

public class LoginTest extends BaseTest {

    @Epic("Модуль авторизации в интернет-магазине")
    @Feature("")
    @Story("")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Volkova Svetlana volkova.sa@yahoo.com")
    @TmsLink("Saucedemo_java")
    @Issue("weblayout")

    @Test(description = "Проверка корректного логина")
    public void correctUserName() {
        System.out.println("CorrectUserName Tests are running in:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertTrue(productsPage.isPageOpen(), "Ожидалось наличие заголовка 'Products'");
        assertEquals(productsPage.getTitleText(), PRODUCTS.getDisplayName());
    }

    @DataProvider(name = "invalidUser")
    public Object[][] loginData() {
        return new Object[][]{{UserFactory.withEmptyUsername(), "Epic sadface: Username is required"}, {UserFactory.withEmptyPassword(), "Epic sadface: Password is required"}, {UserFactory.withLockedUserPermission(), "Epic sadface: Sorry, this user has been locked out."}};
    }

    @Test(dataProvider = "invalidUser")
    public void incorrectLogin(User user, String errorMessage) {
        System.out.println("IncorrectLogin Tests are running in:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user);
        assertEquals(loginPage.checkErrorMsg(), errorMessage);
    }

    @Test(description = "Проверка некорректного логина 'problem_user'")
    public void problemUser() {
        loginPage.open();
        loginPage.login(UserFactory.withProblemUserPermission());
        assertEquals(productsPage.checkImage("Sauce Labs Backpack"), PROBLEM_IMG);
    }

    @Test(description = "Проверка некорректного логина 'performance_glitch_user'")
    public void glitchUser() {
        loginPage.open();
        loginPage.login(UserFactory.withGlitchUserPermission());
        assertTrue(productsPage.isPageOpen(), "Ожидалось наличие заголовка 'Products'");
    }

    @Test(description = "Проверка некорректного логина 'error_user'")
    public void errorUser() throws InterruptedException {
        loginPage.open();
        loginPage.login(UserFactory.withErrorUserPermission());
        productsPage.openProductCard("Sauce Labs Bike Light");
        assertEquals(productCardPage.checkDescription(), "A description should be here, but it failed to render! This error has been reported to Backtrace.");
    }
}
