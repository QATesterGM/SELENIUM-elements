import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitImplicitly {

    private WebDriver driver;
    private String baseUrl;
    private WebElement element;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.selenium-shop.pl/";

        driver.get(baseUrl);
        driver.manage().window().maximize();

        //ImplicitlyWait - oczekiwanie niejawne
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void oczekiwanie_Test() {
        String correctTitle = "Moje konto – Selenium Shop Automatyzacja Testów";

        WebElement mojeKontoMenu = driver.findElement(By.linkText("MOJE KONTO"));
        mojeKontoMenu.click();

        Assert.assertEquals(driver.getTitle(), correctTitle);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}