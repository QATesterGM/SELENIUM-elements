import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Zadanie3Selektory {

    public static WebDriver driver;

    @Test
    public void lokalizowanieElementow_Test2() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/produkt/koszulka-tottenham-hotspur-f-c/");

        WebElement koszulki = driver.findElement(By.linkText("Koszulki"));

        WebElement mojeKonto = driver.findElement(By.linkText("MOJE KONTO"));
        mojeKonto.click();

        WebElement zarejestruj = driver.findElement(By.name("register"));

        WebElement emailAdres = driver.findElement(By.id("reg_email"));

        driver.quit();
    }

    @Test
    public void lokazlizowanieElementowNaKoszyku(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");
        WebElement sklepMenu = driver.findElement(By.linkText("SKLEP"));
        sklepMenu.click();
        WebElement koszulkaChelsea = driver.findElement(By.xpath("//h2[contains(text(),'Chelsea')]"));
        koszulkaChelsea.click();
        WebElement dodajDoKoszykaButton = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
        dodajDoKoszykaButton.click();
        WebElement zobaczKoszykLink = driver.findElement(By.linkText("Zobacz koszyk"));
        zobaczKoszykLink.click();

        WebElement quantity = driver.findElement((By.xpath("//input[starts-with(@id, 'quantity_’)]")));

        WebElement quantityByClass = driver.findElement(By.className("input-text qty text"));

        driver.quit();
    }

    @Test
    public void  weryfikacjaPrzyciskowNaStronieMojeKonto(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        driver.findElement(By.linkText("MOJE KONTO")).click();

        List<WebElement> wszystkiePrzyciski = driver.findElements(By.xpath("//button"));

        int liczbaPrzyciskow = wszystkiePrzyciski.size();

        System.out.println("Liczba przyciskow na stronie = " + liczbaPrzyciskow);

        Assert.assertEquals(liczbaPrzyciskow, 2);

        for(int i = 0; i < liczbaPrzyciskow; i++){
            System.out.println(wszystkiePrzyciski.get(i).getAttribute("value"));
        }

        driver.quit();

    }
}