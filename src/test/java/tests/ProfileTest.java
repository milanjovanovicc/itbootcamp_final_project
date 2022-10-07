package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;

public class ProfileTest extends BaseTest{

    private HomePage homePage;
    private LoginPage loginPage;
    private MyProfilePage myProfilePage;

    @BeforeClass
    private void beforeClass(){
        setup();
        homePage = new HomePage(driver,driverWait);
        loginPage = new LoginPage(driver,driverWait);
        myProfilePage = new MyProfilePage(driver,driverWait);
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getLoginButton()));
        homePage.getLoginButton().sendKeys(Keys.ENTER);

        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByEmail()));
        loginPage.getEmail().sendKeys(loginPage.getAdminEmail());
        loginPage.getPassword().sendKeys(loginPage.getAdminPassword());
        loginPage.getLoginBtn().click();

        //driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getByMyProfile()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.getMyProfile().click();
        
    }

    @Test
    public void verifyEditProfileDisplaysMessage(){
        String expectedResult = "Profile saved successfuly";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(myProfilePage.getBySaveButton()));
        myProfilePage.clearAllFields();
        myProfilePage.getNameField().sendKeys(myProfilePage.getFakeName());
        myProfilePage.getPhoneField().sendKeys(myProfilePage.getFakePhone());
        myProfilePage.getCityField().sendKeys(myProfilePage.getFakeCity());
        myProfilePage.getCountryField().sendKeys(myProfilePage.getFakeCountry());
        myProfilePage.getTwitterField().sendKeys(myProfilePage.getFakeTwitter());
        myProfilePage.getGitHubField().sendKeys(myProfilePage.getFakeGitHub());

        driverWait.until(ExpectedConditions.elementToBeClickable(myProfilePage.getSaveButton()));
        myProfilePage.getSaveButton().click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(myProfilePage.getBySaveMessage()));
        String actualResult = myProfilePage.getSaveMessage().getText();

        Assert.assertTrue(actualResult.contains(expectedResult));

        Assert.assertNotNull(myProfilePage.getNameField().getAttribute("value"));
        Assert.assertNotNull(myProfilePage.getPhoneField().getAttribute("value"));
        Assert.assertNotNull(myProfilePage.getCityField().getAttribute("value"));
        Assert.assertNotNull(myProfilePage.getCountryField().getAttribute("value"));
        Assert.assertNotNull(myProfilePage.getTwitterField().getAttribute("value"));
        Assert.assertNotNull(myProfilePage.getGitHubField().getAttribute("value"));
    }
}
