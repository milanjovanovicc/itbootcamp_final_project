package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage extends BasePage{

    private By nameField = By.id("name");
    private By phoneField = By.id("phone");
    private By cityField = By.id("city");
    private By countryField = By.id("country");
    private By twitterField = By.id("urlTwitter");
    private By gitHubField = By.id("urlGitHub");
    private By saveButton =
            By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private By saveMessage =
            By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");
    private Faker faker = new Faker();


    public MyProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNameField(){
        return getDriver().findElement(nameField);
    }

    public WebElement getPhoneField(){
        return getDriver().findElement(phoneField);
    }

    public WebElement getCityField(){
        return getDriver().findElement(cityField);
    }

    public WebElement getCountryField(){
        return getDriver().findElement(countryField);
    }

    public WebElement getTwitterField(){
        return getDriver().findElement(twitterField);
    }

    public WebElement getGitHubField(){
        return getDriver().findElement(gitHubField);
    }

    public WebElement getSaveButton(){
        return getDriver().findElement(saveButton);
    }

    public By getBySaveButton(){
        return saveButton;
    }

    public String getFakeName(){
        return faker.name().fullName();
    }

    public String getFakePhone(){
        return faker.phoneNumber().phoneNumber();
    }

    public String getFakeCity(){
        return faker.address().city();
    }

    public String getFakeCountry(){
        return faker.address().country();
    }

    public String getFakeTwitter(){
        return "http://" + faker.internet().domainName() + faker.internet().domainSuffix();
    }

    public String getFakeGitHub(){
        return "https://" + faker.internet().domainName() + faker.internet().domainSuffix();
    }

    public WebElement getSaveMessage(){
        return getDriver().findElement(saveMessage);
    }

    public By getBySaveMessage(){
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
