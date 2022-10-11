package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class AuthRoutesTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    private void beforeClass() {
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);

    }

    @Test
    public void verifyHomeIsNotVisitableIfNotAuthenticated() {
        String expectedResult = "/login";

        driver.get(homePage.getHomepageUrl());

        String actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyProfileIsNotVisitableIfNotAuthenticated() {
        String expectedResult = "/login";

        driver.get(homePage.getProfilePage());

        String actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyAdminCitiesNotVisitableIfNotAuthenticated() {
        String expectedResult = "/login";

        driver.get(homePage.getAdminCitiesPage());

        String actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyAdminUsersNotVisitableIfNotAuthenticated() {
        String expectedResult = "/login";

        driver.get(homePage.getAdminUsersPage());

        String actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
