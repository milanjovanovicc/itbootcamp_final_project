package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage extends BasePage {

    private By nameField = By.id("name");
    private By phoneField = By.id("phone");
    private By cityField = By.id("city");
    private By countryField = By.id("country");
    private By twitterField = By.id("urlTwitter");
    private By gitHubField = By.id("urlGitHub");
    private By saveButton = By.className("btnSave");
    private By saveMessage = By.xpath("//div[contains(text(),' Profile saved successfuly ')]");


    public MyProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getPhoneField() {
        return getDriver().findElement(phoneField);
    }

    public WebElement getCityField() {
        return getDriver().findElement(cityField);
    }

    public WebElement getCountryField() {
        return getDriver().findElement(countryField);
    }

    public WebElement getTwitterField() {
        return getDriver().findElement(twitterField);
    }

    public WebElement getGitHubField() {
        return getDriver().findElement(gitHubField);
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public By getBySaveButton() {
        return saveButton;
    }

    public WebElement getSaveMessage() {
        return getDriver().findElement(saveMessage);
    }

    public By getBySaveMessage() {
        return saveMessage;
    }

    public void clearAllFields() {
        getNameField().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getPhoneField().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getCityField().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getCountryField().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getTwitterField().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getGitHubField().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);

    }
}
