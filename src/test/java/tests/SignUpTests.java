package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getSignUpButton()));
        homePage.getSignUpButton().sendKeys(Keys.ENTER);
    }

    @Test(priority = 1)
    public void checksIfItIsOnsignUpPage() {
        String expectedResult = "/signup";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.getBySignMeUpButton()));

        String actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority = 2)
    public void checksInputTypes() {
        String expectedEmail = "email";
        String expectedPassword = "password";
        //String expectedConfirmPassword = "password";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.getBySignMeUpButton()));
        String actualEmail = signUpPage.getEmail().getAttribute("type");
        String actualPassword = signUpPage.getPassword().getAttribute("type");
        String actualConfirmPassword = signUpPage.getConfirmPassword().getAttribute("type");

        Assert.assertEquals(actualEmail, expectedEmail);
        Assert.assertEquals(actualPassword, expectedPassword);
        Assert.assertEquals(actualConfirmPassword, expectedPassword);
    }

    @Test(priority = 3)
    public void verifyErrorDisplayIfUserExists() {
        String expectedUserError = "E-mail already exists";
        String name = "Test Test";
        String email = "admin@admin.com";
        String password = "123654";
        String expectedUrl = "/signup";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.getBySignMeUpButton()));
        signUpPage.getName().sendKeys(name);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword().sendKeys(password);
        signUpPage.getConfirmPassword().sendKeys(password);
        signUpPage.getSignMeUpButton().click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.getByUserError()));
        String actualUserError = signUpPage.getUserError().getText();
        Assert.assertTrue(actualUserError.contains(expectedUserError));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }

    @Test(priority = 4)
    public void signUpWithValidCredentials() {
        //signUpPage.clearAllFields();
        String expectedVerifyYourAccount = "IMPORTANT: Verify your account";
        String name = "Milan Jovanovic";
        String email = "milan.jovanovic@itbootcamp.rs";
        String password = "123456";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPage.getBySignMeUpButton()));
        signUpPage.getName().sendKeys(name);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword().sendKeys(password);
        signUpPage.getConfirmPassword().sendKeys(password);
        signUpPage.getSignMeUpButton().click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(homePage.getByVerifyYourAccount()));
        String actualVerifyYourAccount = homePage.getVerifyYourAccount().getText();
        Assert.assertTrue(actualVerifyYourAccount.contains(expectedVerifyYourAccount));

    }

}
