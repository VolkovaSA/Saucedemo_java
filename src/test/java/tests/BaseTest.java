package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

public class BaseTest {
    WebDriver browser;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--guest");
        browser = new ChromeDriver(options);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        loginPage = new LoginPage(browser);
        productsPage = new ProductsPage(browser);
    }

    @AfterMethod
    public void close() {
        browser.quit();
    }
}
