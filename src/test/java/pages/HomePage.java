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
}
