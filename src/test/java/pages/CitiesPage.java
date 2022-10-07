package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage {

    private By citiesLogout = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button[2]");
    private By newItembutton =
            By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By enterNewCity = By.id("name");
    private By saveNewItem = By.xpath("/html/body/div/div[5]/div/div/div[3]/button[2]");
    private By saveMessage = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By editButton = By.id("edit");
    private By saveEdit = By.xpath("//*[@id='app']/div[5]/div/div/div[3]/button[2]");
    private By enterEditCity = By.id("name");
    private By nameOfTheCity =
            By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");
    private By deleteCity = By.id("delete");
    private By deleteCityConfirm = By.xpath("/html/body/div/div[5]/div/div/div[2]/button[2]");
    private By deletePopup = By.xpath("/html/body/div/div[10]/div/div");
    private By searchBar = By.id("search");
    private By deleteSuccessfull =
            By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

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

    public By getByEnterNewCity() {
        return enterNewCity;
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

    public WebElement getDeletePopup() {
        return getDriver().findElement(deletePopup);
    }

}
