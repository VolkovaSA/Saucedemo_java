package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utilis.PropertyReader;
import utilis.TestListener;

import java.time.Duration;

@Listeners({AllureTestNg.class, TestListener.class})
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductCardPage productCardPage;
    CartPage cartPage;
    String user;
    String password;
    String problemUser;
    String glitchUser;
    String errorUser;
    String lockedOutUser;
    String emptyLoginUser;
    String emptyPasswordUser;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--guest");
            //options.addArguments("headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productCardPage = new ProductCardPage(driver);
        cartPage = new CartPage(driver);

        user = PropertyReader.getProperty("saucedemo.user");
        problemUser = PropertyReader.getProperty("saucedemo.problem_user");
        glitchUser = PropertyReader.getProperty("saucedemo.glitch_user");
        errorUser = PropertyReader.getProperty("saucedemo.error_user");
        lockedOutUser = PropertyReader.getProperty("saucedemo.locked_out_user");
        emptyLoginUser = PropertyReader.getProperty("saucedemo.empty_username");
        emptyPasswordUser = PropertyReader.getProperty("saucedemo.empty_password");
        password = PropertyReader.getProperty("saucedemo.password");
    }

    @Step("Закрытие браузера")
    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}
