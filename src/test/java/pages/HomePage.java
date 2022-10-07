package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By loginButton = By.xpath("/html/body/div/div/div/header/div/div[3]/a[3]");
    private By logoutButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button[2]");
    private By logoutText = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button[2]/span");
    private By homeButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/a[1]");
    private By signUpButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/a[4]");
    private By verifyYourAccount = By.xpath("/html/body/div/div[4]/div/div/div[1]");
    private By adminButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button[1]");
    private By adminListCities = By.xpath("//*[@id='app']/div[3]/div[1]/a[1]");
    private String homepageUrl = new String("https://vue-demo.daniel-avellaneda.com/home");
    private String profilePage = new String("https://vue-demo.daniel-avellaneda.com/profile");
    private String adminCitiesPage = new String("https://vue-demo.daniel-avellaneda.com/admin/cities");
    private String adminUsersPage = new String("https://vue-demo.daniel-avellaneda.com/admin/users");
    private By localeButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button");
    private By localeListES = By.xpath("/html/body/div/div[2]/div/div[2]");
    private By headerText = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    private By localeListEN = By.xpath("/html/body/div/div[2]/div/div[1]");
    private By localeListFR = By.xpath("/html/body/div/div[2]/div/div[3]");

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

    public WebElement getHomeButton() {
        return getDriver().findElement(homeButton);
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

    public By getByLoginButton() {
        return loginButton;
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

    public By getByAdminListCities() {
        return adminListCities;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public String getProfilePage() {
        return profilePage;
    }

    public String getAdminCitiesPage() {
        return adminCitiesPage;
    }

    public String getAdminUsersPage() {
        return adminUsersPage;
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

}
