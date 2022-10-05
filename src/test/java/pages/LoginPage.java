package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By email = By.id("email");
    private By password = By.id("password");
    private By loginBtn = By.xpath("/html/body/div/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By userErrorWindow = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By userErrorMessage = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By passwordErrorWindow = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By passwordErrorMessage = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By userErrorButton = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/button");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
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

    public By getByUserErrorWindow() {
        return userErrorWindow;
    }

    public WebElement getPasswordErrorMessage() {
        return getDriver().findElement(passwordErrorMessage);
    }

    public By getByPasswordErrorWindow() {
        return passwordErrorWindow;
    }

    public void clearEmailPasswordFields() {
        getEmail().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getPassword().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }
}
