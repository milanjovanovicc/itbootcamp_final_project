package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CitiesPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminCitiesTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private CitiesPage citiesPage;

    @BeforeClass
    public void beforeClass() {
        setup();
        homePage = new HomePage(driver, driverWait);
        citiesPage = new CitiesPage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getLoginButton()));
        homePage.getLoginButton().sendKeys(Keys.ENTER);

    }

    @BeforeMethod
    public void beforeMethod() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getByEmail()));
        loginPage.getEmail().sendKeys(loginPage.getAdminEmail());
        loginPage.getPassword().sendKeys(loginPage.getAdminPassword());
        loginPage.getLoginBtn().click();

        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getByAdminButton()));
        homePage.getAdminButton().click();

        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getAdminListCities()));
        homePage.getAdminListCities().click();
    }

    @Test(priority = 1)
    public void verifyCitiesPageAndListExists() {
        String expectedUrl = "/admin/cities";
        String expectedLogoutBtn = "LOGOUT";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(citiesPage.getByCitiesLogout()));
        String actualUrl = driver.getCurrentUrl();
        String actualLogoutBtn = citiesPage.getCitiesLogout().getText();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Assert.assertEquals(actualLogoutBtn, expectedLogoutBtn);

    }

    @Test(priority = 2)
    public void verifyNewCityIsCreated() {
        String expectedResult = "Saved successfully";

        driverWait.until(ExpectedConditions.elementToBeClickable(citiesPage.getNewItembutton()));
        citiesPage.getNewItembutton().click();

        driverWait.until(ExpectedConditions.visibilityOf(citiesPage.getEnterNewCity()));
        citiesPage.getEnterNewCity().sendKeys(citiesPage.getCityName());

        driverWait.until(ExpectedConditions.elementToBeClickable(citiesPage.getSaveNewItem()));
        citiesPage.getSaveNewItem().click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(citiesPage.getBySaveMessage()));
        String actualResult = citiesPage.getSaveMessage().getText();

        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test(priority = 3)
    private void verifyCityIsEdited() {
        String expectedResponse = "Saved successfully";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(citiesPage.getByEditButton()));
        citiesPage.getEditButton().click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(citiesPage.getBySaveEdit()));
        citiesPage.clearCityNameFiled();
        citiesPage.getEnterCityName().sendKeys(citiesPage.getEditedCityName());

        driverWait.until(ExpectedConditions.elementToBeClickable(citiesPage.getSaveEdit()));
        citiesPage.getSaveEdit().click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(citiesPage.getBySaveMessage()));
        String actualResponse = citiesPage.getSaveMessage().getText();

        Assert.assertTrue(actualResponse.contains(expectedResponse));

    }

    @Test(priority = 4)
    public void verifySearchWorks() {
        String expectedResult = "Morinj";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(citiesPage.getBySearchBar()));
        citiesPage.getSearchBar().sendKeys(citiesPage.getEditedCityName());

        driverWait.until(ExpectedConditions.presenceOfElementLocated(citiesPage.getByNameOfTheCity()));
        String actualResult = citiesPage.getNameOfTheCity().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test(priority = 5)
    public void verifyCityIsDeleted() {
        String expecetedMessage = "Deleted successfully";
        String expectedCity = "Morinj";

        driverWait.until(ExpectedConditions.presenceOfElementLocated(citiesPage.getBySearchBar()));
        citiesPage.getSearchBar().sendKeys(citiesPage.getCityName());

        driverWait.until(ExpectedConditions.numberOfElementsToBe(citiesPage.getByNameOfTheCity(), 1));
        String actualCity = citiesPage.getNameOfTheCity().getText();
        Assert.assertTrue(actualCity.contains(expectedCity));
        citiesPage.getDeleteCity().click();

        driverWait.until(ExpectedConditions.visibilityOf(citiesPage.getDeleteCityConfirm()));
        citiesPage.getDeleteCityConfirm().click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(citiesPage.getByDeleteSuccessfull()));
        String actualMessage = citiesPage.getDeleteSuccessfull().getText();
        Assert.assertTrue(actualMessage.contains(expecetedMessage));
    }

    @AfterMethod
    public void afterMethod() {
        afterMethodSetup();
    }
}