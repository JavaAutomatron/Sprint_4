
import PomClasses.PageAboutUser;
import PomClasses.PageAboutDelivery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderFormTest {
    //Order Button location
    private final String orderButtonLocation;
    //Name input
    private final String inputNameField;
    //lastName input
    private final String inputLastNameField;
    //Address input
    private final String inputAddressField;
    private final String stationFieldValue;
    //mobile phone number input
    private final String inputPhoneNumberField;
    //order date
    private final String dateValue;
    //Additional info for courier
    private final String comment;


    public OrderFormTest(String orderButtonLocation, String inputNameField, String inputLastNameField, String inputAddressField, String stationFieldValue,
                         String inputPhoneNumberField, String dateValue, String comment) {
        this.orderButtonLocation = orderButtonLocation;
        this.inputNameField = inputNameField;
        this.inputLastNameField = inputLastNameField;
        this.inputAddressField = inputAddressField;
        this.stationFieldValue = stationFieldValue;
        this.inputPhoneNumberField = inputPhoneNumberField;
        this.dateValue = dateValue;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getValues() {
        return new Object[][]{
                {"//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]", "СтасСтасСт", "СловецкийС", "Хамовнический Вал, 34", "Маяковская", "12345678901", "31.12.2022", "Позвонить в 7:00"},
                {"//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button","СтасСтасСтасСтасСтас", "СловецкийСловец", "Хамовнический Вал, 34Хамовнический Вал, 34Хамов", "Лубянка",
                        "+7 985 565-54-547", "31.12.2022", "Позвонить в 7:00"}
        };
    }
    //Drop comments to change browser
    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver.manage().window().maximize();
    }
    //Drop comments to change browser
    ChromeDriver driver = new ChromeDriver();
    //FirefoxDriver driver = new FirefoxDriver();

    @Test
    public void setQnACheckChrome() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        PageAboutUser QnACheck1 = new PageAboutUser(driver);
        QnACheck1.fillInFirstOrderPage(By.xpath(orderButtonLocation), inputNameField, inputLastNameField,
                inputAddressField, stationFieldValue, inputPhoneNumberField);
        PageAboutDelivery QnACheck2 = new PageAboutDelivery(driver);
        QnACheck2.fillInSecondPage(dateValue);
        assertTrue(QnACheck2.confirmationHeaderAppears());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
