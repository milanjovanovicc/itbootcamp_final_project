package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests {

    private HomePage homePage;

    private LoginPage loginPage;
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeClass
    public void beforeclass() {
        System.setProperty("webdriver.gecko.driver", "C:\\Milan\\Programiranje\\Java\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement emailLocation = driver.findElement(By.id("email"));
        emailLocation.sendKeys("");
        WebElement passwordLocation = driver.findElement(By.id("password"));
        passwordLocation.clear();
        //driver.navigate().refresh();
    }

    @Test
    public void checksIfItIsOnLoginPage() {
        String expectedResult = "/login";

        String actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void checkInputTypes() {
        String expectedEmail = "email";
        String expectedPassword = "password";

        String actualEmail = loginPage.getEmail().getAttribute("type");
        String actualPassword = loginPage.getPassword().getAttribute("type");

        Assert.assertEquals(actualEmail, expectedEmail);
        Assert.assertEquals(actualPassword, expectedPassword);

    }

    @Test
    public void loginWithInvalidEmail() {
        Faker faker = new Faker();

        String expectedText = "User does not exists";
        String expectedUrl = "/login";

        loginPage.getEmail().sendKeys(faker.internet().emailAddress());

        loginPage.getPassword().sendKeys(faker.internet().password());

        driverWait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.getLoginBtn().sendKeys(Keys.ENTER);

        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByUserErrorWindow()));
        String actualText = loginPage.getUserErrorMessage().getText();

        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));

    }

    @Test
    public void loginWithInvalidPassword() {
        Faker faker = new Faker();

        String expectedText = "Wrong password";
        String expectedUrl = "/login";

        loginPage.getEmail().sendKeys("admin@admin.com");

        loginPage.getPassword().sendKeys(faker.internet().password());

        driverWait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.getLoginBtn().sendKeys(Keys.ENTER);

        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByPasswordErrorWindow()));
        String actualText = loginPage.getPasswordErrorMessage().getText();

        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }

    @Test
    public void loginWithValidCredentials(){
        String expectedUrl = "/home";

        loginPage.getEmail().sendKeys("admin@admin.com");

        loginPage.getPassword().sendKeys("12345");

        driverWait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.getLoginBtn().sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }

}
