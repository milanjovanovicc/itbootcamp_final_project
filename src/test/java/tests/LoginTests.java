package tests;

import Extras.FakerClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private FakerClass fakerClass;

    @BeforeClass
    public void Beforeclass() {
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        fakerClass = new FakerClass();
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getLoginButton()));
        homePage.getLoginButton().sendKeys(Keys.ENTER);
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

        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByEmail()));

        String actualEmail = loginPage.getEmail().getAttribute("type");
        String actualPassword = loginPage.getPassword().getAttribute("type");

        Assert.assertEquals(actualEmail, expectedEmail);
        Assert.assertEquals(actualPassword, expectedPassword);

    }

    @Test
    public void loginWithInvalidEmail() {
        String expectedText = "User does not exists";
        String expectedUrl = "/login";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByEmail()));

        loginPage.getEmail().sendKeys(fakerClass.getFakeEmail());
        loginPage.getPassword().sendKeys(fakerClass.getFakePassword());

        driverWait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.getLoginBtn().sendKeys(Keys.ENTER);

        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByUserErrorWindow()));
        String actualText = loginPage.getUserErrorMessage().getText();

        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));

    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.clearEmailPasswordFields();

        String expectedText = "Wrong password";
        String expectedUrl = "/login";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByEmail()));
        loginPage.getEmail().sendKeys(loginPage.getAdminEmail());
        loginPage.getPassword().sendKeys(fakerClass.getFakePassword());

        driverWait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.getLoginBtn().sendKeys(Keys.ENTER);

        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByPasswordErrorWindow()));
        String actualText = loginPage.getPasswordErrorMessage().getText();

        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));

    }

    @Test
    public void loginWithValidCredentials() {
        String expectedUrl = "/home";

        loginPage.clearEmailPasswordFields();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByEmail()));
        loginPage.getEmail().sendKeys(loginPage.getAdminEmail());
        loginPage.getPassword().sendKeys(loginPage.getAdminPassword());

        driverWait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.getLoginBtn().sendKeys(Keys.ENTER);

        driverWait.until(ExpectedConditions.presenceOfElementLocated(homePage.getByLogoutButton()));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        afterMethodSetup();
    }

    @Test
    public void logoutTest() {

        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByEmail()));
        loginPage.getEmail().sendKeys(loginPage.getAdminEmail());
        loginPage.getPassword().sendKeys(loginPage.getAdminPassword());
        loginPage.getLoginBtn().click();

        String expectedLogout = "LOGOUT";
        String expectedLogin = "/login";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(homePage.getByLogoutButton()));
        String actualLogout = homePage.getLogoutText().getText();

        Assert.assertEquals(actualLogout, expectedLogout);

        homePage.getLogoutButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getLoginBtn()));
        String actualLogin = driver.getCurrentUrl();
        System.out.println(actualLogin);
        Assert.assertTrue(actualLogin.contains(expectedLogin));

        driver.get(homePage.getHomepageUrl());
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedLogin));
    }


}
