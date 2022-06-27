import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumWieleOkienPrzegladarki {

    public static WebDriver driver;

    @Test
    public void SeleniumWieleOkienPrzegladarki(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.selenium-shop.pl/");

        System.out.println("tytuł strony: " + driver.getTitle());
        System.out.println("Ankieta Okna ID: " + driver.getWindowHandle());
    }
}
