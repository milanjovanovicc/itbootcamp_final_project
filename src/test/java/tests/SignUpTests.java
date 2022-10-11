package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class SignUpTests extends BaseTest {

    private HomePage homePage;
    private SignUpPage signUpPage;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        setup();
        homePage = new HomePage(driver, driverWait);
        signUpPage = new SignUpPage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);

    }

    @BeforeMethod
    public void beforeMethod() {
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getSignUpButton()));
        homePage.getSignUpButton().sendKeys(Keys.ENTER);
    }

    @Test
    public void checksIfItIsOnsignUpPage() {
        String expectedResult = "/signup";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.getBySignMeUpButton()));

        String actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void checksInputTypes() {
        String expectedEmail = "email";
        String expectedPassword = "password";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.getBySignMeUpButton()));
        String actualEmail = signUpPage.getEmail().getAttribute("type");
        String actualPassword = signUpPage.getPassword().getAttribute("type");
        String actualConfirmPassword = signUpPage.getConfirmPassword().getAttribute("type");

        Assert.assertEquals(actualEmail, expectedEmail);
        Assert.assertEquals(actualPassword, expectedPassword);
        Assert.assertEquals(actualConfirmPassword, expectedPassword);
    }

    @Test
    public void verifyErrorDisplayIfUserExists() {
        String expectedUserError = "E-mail already exists";
        String expectedUrl = "/signup";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.getBySignMeUpButton()));
        signUpPage.getName().sendKeys(signUpPage.getAdminName());
        signUpPage.getEmail().sendKeys(signUpPage.getAdminEmail());
        signUpPage.getPassword().sendKeys(signUpPage.getAdminPassword());
        signUpPage.getConfirmPassword().sendKeys(signUpPage.getAdminPassword());
        signUpPage.getSignMeUpButton().click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.getByUserError()));
        String actualUserError = signUpPage.getUserError().getText();
        Assert.assertTrue(actualUserError.contains(expectedUserError));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }

    @Test
    public void signUpWithValidCredentials() {
        signUpPage.clearAllFields();
        String expectedVerifyYourAccount = "IMPORTANT: Verify your account";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.getBySignMeUpButton()));
        signUpPage.getName().sendKeys(signUpPage.getValidName());
        signUpPage.getEmail().sendKeys(signUpPage.getValidEmail());
        signUpPage.getPassword().sendKeys(signUpPage.getValidPassword());
        signUpPage.getConfirmPassword().sendKeys(signUpPage.getValidPassword());
        signUpPage.getSignMeUpButton().click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(homePage.getByVerifyYourAccount()));
        String actualVerifyYourAccount = homePage.getVerifyYourAccount().getText();
        Assert.assertTrue(actualVerifyYourAccount.contains(expectedVerifyYourAccount));

        driverWait.until(ExpectedConditions.visibilityOf(signUpPage.getVerifyUserCancelBtn()));
        signUpPage.getVerifyUserCancelBtn().click();

        afterMethodSetup();
        loginPage.getHomeButton().click();

    }

}
