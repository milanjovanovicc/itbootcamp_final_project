package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class LocaleTest extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = new HomePage(driver, driverWait);

    }

    @BeforeMethod
    public void beforeMethod() {
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getByLocaleButton()));
        homePage.getLocaleButton().click();
    }

    @Test
    public void verifyLocaleEsText() {
        String expectedResult = "Página de aterrizaje";

        driverWait.until(ExpectedConditions.visibilityOf(homePage.getLocaleListES()));
        homePage.getLocaleListES().click();

        driverWait.until(ExpectedConditions.visibilityOf(homePage.getHeaderText()));
        String actualResult = homePage.getHeaderText().getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyLocaleEnText() {
        String expectedResult = "Landing";

        driverWait.until(ExpectedConditions.visibilityOf(homePage.getLocaleListEN()));
        homePage.getLocaleListEN().click();

        driverWait.until(ExpectedConditions.visibilityOf(homePage.getHeaderText()));
        String actualResult = homePage.getHeaderText().getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyLocaleFrText() {
        String expectedResult = "Page d'atterrissage";

        driverWait.until(ExpectedConditions.visibilityOf(homePage.getLocaleListFR()));
        homePage.getLocaleListFR().click();

        driverWait.until(ExpectedConditions.visibilityOf(homePage.getHeaderText()));
        String actualResult = homePage.getHeaderText().getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
