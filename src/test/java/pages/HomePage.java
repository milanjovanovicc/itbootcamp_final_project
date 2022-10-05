package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By login = By.xpath("/html/body/div/div/div/header/div/div[3]/a[3]");
    private By logoutButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button[2]");
    private By logoutText = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button[2]/span");
    private By homeButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/a[1]");


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLogin() {
        return getDriver().findElement(login);
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
}
