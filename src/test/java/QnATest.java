import PomClasses.PomQnA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

public class QnATest {
    @Before
    public void startUp() {
        //Drop comments to change browser
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver.manage().window().maximize();

    }
    //Drop comments to change browser
    ChromeDriver driver = new ChromeDriver();
    //FirefoxDriver driver = new FirefoxDriver();

    @Test
    public void setQnAcheckChrome() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        PomQnA QnACheck = new PomQnA(driver);
        String[] actualAnswers = QnACheck.pressPointerButtonAndScanText();
        for (int i = 0; i < actualAnswers.length; i++){
            assertEquals(QnACheck.expected[i], actualAnswers[i]);
            System.out.println("Expected: \n" + QnACheck.expected[i] + "\nActual:\n" +
                    actualAnswers[i] + "\n-----------------------------------------");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
