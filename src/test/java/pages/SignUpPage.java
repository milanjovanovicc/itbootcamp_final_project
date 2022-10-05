package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    private By name = By.id("name");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By signMeUpButton =
            By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
    private By userError =
            By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");

    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);

    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getConfirmPassword() {
        return getDriver().findElement(confirmPassword);
    }

    public WebElement getSignMeUpButton() {
        return getDriver().findElement(signMeUpButton);
    }

    public By getBySignMeUpButton() {
        return signMeUpButton;
    }

    public WebElement getUserError() {
        return getDriver().findElement(userError);
    }

    public By getByUserError() {
        return userError;
    }

    public void clearAllFields() {
        getName().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getEmail().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getPassword().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getConfirmPassword().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }
}
