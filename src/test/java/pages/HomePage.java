package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By loginButton = By.xpath("//a[@href='/login']");
    private By logoutButton = By.className("btnLogout");
    private By logoutText = By.xpath("//span[contains(text(),'Logout')]");
    private By signUpButton = By.xpath("//a[@href='/signup']");
    private By verifyYourAccount = By.xpath("//div[contains(text(),' IMPORTANT: Verify your account ')]");
    private By adminButton = By.className("btnAdmin");
    private By adminListCities = By.xpath("//a[@href='/admin/cities']");
    private By localeButton = By.className("btnLocaleActivation");
    private By localeListES = By.className("btnES");

    private By headerText = By.className("display-2");

    private By localeListEN = By.className("btnEN");

    private By localeListFR = By.className("btnFR");

    private By myProfile = By.className("btnProfile");


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public WebElement getLogoutText() {
        return getDriver().findElement(logoutText);
    }

    public By getByLogoutButton() {
        return logoutButton;
    }

    public WebElement getSignUpButton() {
        return getDriver().findElement(signUpButton);
    }

    public WebElement getVerifyYourAccount() {
        return getDriver().findElement(verifyYourAccount);
    }

    public By getByVerifyYourAccount() {
        return verifyYourAccount;
    }

    public WebElement getAdminButton() {
        return getDriver().findElement(adminButton);
    }

    public By getByAdminButton() {
        return adminButton;
    }

    public WebElement getAdminListCities() {
        return getDriver().findElement(adminListCities);
    }

    public String getHomepageUrl() {
        return "https://vue-demo.daniel-avellaneda.com/home";
    }

    public String getProfilePage() {
        return "https://vue-demo.daniel-avellaneda.com/profile";
    }

    public String getAdminCitiesPage() {
        return "https://vue-demo.daniel-avellaneda.com/admin/cities";
    }

    public String getAdminUsersPage() {
        return "https://vue-demo.daniel-avellaneda.com/admin/users";
    }

    public WebElement getLocaleButton() {
        return getDriver().findElement(localeButton);
    }

    public By getByLocaleButton() {
        return localeButton;
    }

    public WebElement getLocaleListES() {
        return getDriver().findElement(localeListES);
    }

    public WebElement getHeaderText() {
        return getDriver().findElement(headerText);
    }

    public WebElement getLocaleListEN() {
        return getDriver().findElement(localeListEN);
    }

    public WebElement getLocaleListFR() {
        return getDriver().findElement(localeListFR);
    }

    public WebElement getMyProfile() {
        return getDriver().findElement(myProfile);
    }

    public By getByMyProfile() {
        return myProfile;
    }

}
