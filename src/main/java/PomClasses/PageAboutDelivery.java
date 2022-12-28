package PomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class PageAboutDelivery {
    private WebDriver driver;
    //Order form header (second page)
    private By HeaderOrderForm = By.className("Order_Header__BZXOb");
    //Delivery time input
    private By deliveryDateInput = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");
    //Dropdown button
    private By dropdownButtonRent = By.className("Dropdown-placeholder");
    //Rent duration
    private By durationSelectionOneDay = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    //Colour selection button (black)
    private By colourButtonBlack = By.id("black");
    //Colour selection button (grey)
    private By colourButtonGrey = By.id("grey");
    //Additional info for courier
    private By addInfoForCourier = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    //Go back button
    private By goBackButton = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[3]/button[1]");
    //Header at decision window
    private By orderDecisionHeader = By.className("Order_ModalHeader__3FDaJ");
    //Yes button
    private By yesButton = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    //No button
    private By noButton = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[1]");
    //Order Confirmation header
    private By confirmationHeader = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]/div");

    public PageAboutDelivery(WebDriver driver) {
        this.driver = driver;
    }

    public void setDeliveryDateInput(String dateValue) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
        driver.findElement(deliveryDateInput).sendKeys(dateValue);
        driver.findElement(By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input")).sendKeys(Keys.ENTER);
    }

    public void clickDropdownButtonRent() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(dropdownButtonRent).click();
        driver.findElement(durationSelectionOneDay).click();
    }

    public void clickColorCheckbox() {
        driver.findElement(colourButtonGrey).click();
        //driver.findElement(durationSelectionOneDay).click();
    }
    public void setAddInfoForCourier(String comment) {
        driver.findElement(addInfoForCourier).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(By.xpath(".//*[@id=\"root\"]/div/div[2]/div[3]/button[2]")).click();
    }

    public void confirmDelivery() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
        driver.findElement(yesButton).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                visibilityOfElementLocated(confirmationHeader));
    }
    public boolean confirmationHeaderAppears() {
        return driver.findElement(confirmationHeader).isEnabled();
    }

    public void fillInSecondPage(String dateValue) {
        setDeliveryDateInput(dateValue);
        clickDropdownButtonRent();
        clickColorCheckbox();
        clickOrderButton();
        confirmDelivery();
    }
}