package PomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAboutUser {
    private WebDriver driver;
    //Order button
    private By orderButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    //Order button in the middle of the page
    private By orderButtonMiddle = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    //Order form header (first page)
    private By headerOrderForm = By.className("Order_Header__BZXOb");
    //Name input
    private By inputNameField = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    //lastName input
    private By inputLastNameField = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    //Address input
    private By inputAddressField = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    //Metro Station selection
    private By selectStationField = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    //phone number input
    private By inputPhoneNumberField = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    //"Next" button
    private By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    public PageAboutUser(WebDriver driver) {
        this.driver = driver;
    }
    public void setInputNameField(String nameValue) {
        driver.findElement(inputNameField).sendKeys(nameValue);
    }
    public void setInputLastNameField(String lNameValue) {
        driver.findElement(inputLastNameField).sendKeys(lNameValue);
    }
    public void setInputAddressField(String addressValue) {
        driver.findElement(inputAddressField).sendKeys(addressValue);
    }
    public void setSelectStationField(String stationFieldValue) {
        driver.findElement(selectStationField).sendKeys(stationFieldValue);
    }
    public void selectStationDropDownList() {
        driver.findElement(By.className("select-search__input")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.className("select-search__input")).sendKeys(Keys.ENTER);
    }
    public void setInputPhoneNumberField(String phoneNumberFieldValue) {
        driver.findElement(inputPhoneNumberField).sendKeys(phoneNumberFieldValue);
    }
    public void clickOrderButton(String clickOrderButton) {
        driver.findElement(orderButton).sendKeys(clickOrderButton);
    }

    public void clickOrderButtonMiddle(String nameValue) {
        driver.findElement(inputNameField).sendKeys(nameValue);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void fillInFirstOrderPage(By orderButtonLocation, String nameValue, String lNameValue, String addressValue, String stationFieldValue,
                                     String phoneNumberFieldValue) {
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        driver.findElement(orderButtonLocation).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(headerOrderForm));
        setInputNameField(nameValue);
        setInputLastNameField(lNameValue);
        setInputAddressField(addressValue);
        setSelectStationField(stationFieldValue);
        selectStationDropDownList();
        setInputPhoneNumberField(phoneNumberFieldValue);
        clickNextButton();
    }
}
