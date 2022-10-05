package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
    }

/*    @BeforeMethod
    public void beforeMethod() {
        loginPage.getEmail().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        loginPage.getPassword().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }*/

    @Test(priority = 1)
    public void checksIfItIsOnLoginPage() {
        String expectedResult = "/login";

        String actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority = 2)
    public void checkInputTypes() {
        String expectedEmail = "email";
        String expectedPassword = "password";

        String actualEmail = loginPage.getEmail().getAttribute("type");
        String actualPassword = loginPage.getPassword().getAttribute("type");

        Assert.assertEquals(actualEmail, expectedEmail);
        Assert.assertEquals(actualPassword, expectedPassword);

    }

    @Test(priority = 3)
    public void loginWithInvalidEmail() {
        Faker faker = new Faker();
        loginPage.clearEmailPasswordFields();

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

    @Test(priority = 4)
    public void loginWithInvalidPassword() {
        Faker faker = new Faker();
        loginPage.clearEmailPasswordFields();

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

    @Test(priority = 5)
    public void loginWithValidCredentials() {
        String expectedUrl = "/home";
        loginPage.clearEmailPasswordFields();

        loginPage.getEmail().sendKeys("admin@admin.com");

        loginPage.getPassword().sendKeys("12345");

        driverWait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.getLoginBtn().sendKeys(Keys.ENTER);
        //driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getLogoutButton()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test(priority = 6)
    public void logout() {

        String expectedLogout = "LOGOUT";
        String expectedLogin = "/login";

        String actualLogout = homePage.getLogoutText().getText();

        Assert.assertEquals(actualLogout, expectedLogout);

        homePage.getLogoutButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getLoginBtn()));
        String actualLogin = driver.getCurrentUrl();
        System.out.println(actualLogin);
        Assert.assertTrue(actualLogin.contains(expectedLogin));

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedLogin));
    }
}
