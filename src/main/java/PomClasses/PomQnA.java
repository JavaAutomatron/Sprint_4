package PomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PomQnA {
    private WebDriver driver;
    private By[] questionButton = new By[]
            {By.id("accordion__heading-0"), By.id("accordion__heading-1"), By.id("accordion__heading-2"),
                    By.id("accordion__heading-3"), By.id("accordion__heading-4"),
                    By.id("accordion__heading-5"), By.id("accordion__heading-6"),
                    By.id("accordion__heading-7")};
    private By[] answerText = new By[]{By.xpath(".//*[@id='accordion__panel-0']/p"),
            By.xpath(".//*[@id='accordion__panel-1']/p"),
            By.xpath(".//*[@id='accordion__panel-2']/p"), By.xpath(".//*[@id='accordion__panel-3']/p"),
            By.xpath(".//*[@id='accordion__panel-4']/p"), By.xpath(".//*[@id='accordion__panel-5']/p"),
            By.xpath(".//*[@id='accordion__panel-6']/p"), By.xpath(".//*[@id='accordion__panel-7']/p")};
    //Create an array with answer text
    public String[] expected = new String[]{
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                    "можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                    "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                    "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
                    "даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };
    public PomQnA(WebDriver driver) {
        this.driver = driver;
    }

    public String[] pressPointerButtonAndScanText() {//(questionButton)
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        String[] ansText = new String[8];
        for (int i = 0; i < questionButton.length; i++) {
            driver.findElement(questionButton[i]).click();
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(answerText[i]));
            ansText[i] = driver.findElement(answerText[i]).getText();
        }
        return ansText;
    }
}
