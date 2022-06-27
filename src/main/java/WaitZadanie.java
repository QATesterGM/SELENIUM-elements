import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitZadanie {

    public static WebDriver driver;

    @Test
    public void mechanizmOczekiwania_Test() {


//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,30);

//Krok 1
        driver.get("http://www.selenium-shop.pl/");

//Krok 2
        WebElement mojeKontoMenu = driver.findElement(By.linkText("ANKIETA"));
        mojeKontoMenu.click();

//Krok 3
        WebElement procesButton = driver.findElement(By.id("proces"));
        procesButton.click();

//Krok 4
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Element Proces został wyświetlony')]")));

//Krok 5
        WebElement komunikat = driver.findElement(By.xpath("//span[contains(text(),'Element Proces został wyświetlony')]"));
        Assert.assertTrue(komunikat.isDisplayed(), "Komunikat nie jest widoczny na stronie");

//Zamknięcie przeglądarki
        driver.close();

    }

    @Test
    public void mechanizmOczekiwania_Test2() {

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,30);

        JavascriptExecutor js = (JavascriptExecutor) driver;

//Krok 1
        driver.get("http://www.selenium-shop.pl/");

        wait.until(ExpectedConditions.titleIs("Selenium Shop Automatyzacja Testów"));

//Skrolowanie do elementu
        js.executeScript("window.scrollBy(0,1200)");

//Krok 2,3
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'See all')]"))).click();

//Krok 4,5
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Koszulka Arsenal London')]"))).click();

//Krok 6,7
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //button[@name='add-to-cart']"))).click();

//Krok 8
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("woocommerce-message")));

//Zamknięcie przeglądarki
        driver.close();

    }
}