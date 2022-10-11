package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By email = By.id("email");
    private By password = By.id("password");
    private By loginBtn = By.className("secondary");
    private By userErrorMessage = By.xpath("//li[contains(text(),'User does not exists')]");
    private By passwordErrorMessage = By.xpath("//li[contains(text(),'Wrong password')]");
    private By homeButton = By.xpath("//a[@href='/']");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public By getByEmail() {
        return email;
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }

    public WebElement getUserErrorMessage() {
        return getDriver().findElement(userErrorMessage);
    }

    public By getByUserErrorMessage() {
        return userErrorMessage;
    }

    public WebElement getPasswordErrorMessage() {
        return getDriver().findElement(passwordErrorMessage);
    }

    public By getByPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public WebElement getHomeButton() {
        return getDriver().findElement(homeButton);
    }

    public String getAdminEmail() {
        return "admin@admin.com";
    }

    public String getAdminPassword() {
        return "12345";
    }

    public void clearEmailPasswordFields() {
        getEmail().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getPassword().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }

}
