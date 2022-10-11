package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage {

    private By citiesLogout = By.className("btnLogout");
    private By newItembutton = By.className("btnNewItem");
    private By enterNewCity = By.id("name");
    private By saveNewItem = By.className("btnSave");
    private By saveMessage = By.xpath("//div[contains(text(),'Saved successfully')]");
    private By editButton = By.id("edit");
    private By saveEdit = By.xpath("//*[@id='app']/div[5]/div/div/div[3]/button[2]");
    private By nameOfTheCity = By.xpath("//tr/td[2]");
    private By deleteCity = By.id("delete");
    private By deleteCityConfirm = By.className("text--lighten3");
    private By searchBar = By.id("search");
    private By deleteSuccessfull = By.xpath("//div[contains(text(),'Deleted successfully')]");

    public CitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getCitiesLogout() {
        return getDriver().findElement(citiesLogout);
    }

    public By getByCitiesLogout() {
        return citiesLogout;
    }

    public WebElement getNewItembutton() {
        return getDriver().findElement(newItembutton);
    }

    public WebElement getEnterNewCity() {
        return getDriver().findElement(enterNewCity);
    }

    public WebElement getSaveNewItem() {
        return getDriver().findElement(saveNewItem);
    }

    public WebElement getSaveMessage() {
        return getDriver().findElement(saveMessage);
    }

    public By getBySaveMessage() {
        return saveMessage;
    }

    public WebElement getEditButton() {
        return getDriver().findElement(editButton);
    }

    public By getByEditButton() {
        return editButton;
    }

    public WebElement getSaveEdit() {
        return getDriver().findElement(saveEdit);
    }

    public String getCityName() {
        return "Morinj";
    }

    public String getEditedCityName() {
        return "Morinj edited";
    }

    public WebElement getEnterCityName() {
        return getDriver().findElement(enterNewCity);
    }

    public void clearCityNameFiled() {
        getEnterCityName().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }

    public By getBySaveEdit() {
        return saveEdit;
    }

    public WebElement getNameOfTheCity() {
        return getDriver().findElement(nameOfTheCity);
    }

    public By getByNameOfTheCity() {
        return nameOfTheCity;
    }

    public WebElement getSearchBar() {
        return getDriver().findElement(searchBar);
    }

    public By getBySearchBar() {
        return searchBar;
    }

    public WebElement getDeleteCity() {
        return getDriver().findElement(deleteCity);
    }

    public WebElement getDeleteCityConfirm() {
        return getDriver().findElement(deleteCityConfirm);
    }

    public WebElement getDeleteSuccessfull() {
        return getDriver().findElement(deleteSuccessfull);
    }

    public By getByDeleteSuccessfull() {
        return deleteSuccessfull;
    }


}
