package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import pages.HomePage;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected HomePage homePage;

    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Milan\\Programiranje\\Java\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver, driverWait);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void afterMethodSetup() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(homePage.getByLogoutButton()));
        homePage.getLogoutButton().click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
