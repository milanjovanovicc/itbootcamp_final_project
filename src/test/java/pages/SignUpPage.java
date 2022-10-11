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
    private By signMeUpButton = By.className("secondary");
     private By userError = By.xpath("//li[contains(text(),'E-mail already exists')]");
    public By verifyUserCancelBtn = By.className("btnClose");
    public String adminName = "Test Test";
    public String adminEmail = "admin@admin.com";
    public String adminPassword = "123654";
    public String validName = "Milan Jovanovic";
    public String validEmail = "milan.jovanovic@itbootcamp.rs";
    public String validPassword = "123456";

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

    public WebElement getVerifyUserCancelBtn() {
        return getDriver().findElement(verifyUserCancelBtn);
    }

    public void clearAllFields() {
        getName().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getEmail().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getPassword().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getConfirmPassword().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getValidName() {
        return validName;
    }

    public String getValidEmail() {
        return validEmail;
    }

    public String getValidPassword() {
        return validPassword;
    }
}
