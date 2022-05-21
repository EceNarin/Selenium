package SecondWeekSelenium.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandle {
  WebDriver driver;
    @Test
    public void test() throws InterruptedException {
        // 1- amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        String wHandle= driver.getWindowHandle();//has code test her calıstıgında bu hashcode degisir
        // 2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" +Keys.ENTER);
        Thread.sleep(3000);
        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        Thread.sleep(3000);
        // 4- yeni tab'da acilan urunun title'ini yazdirin
        System.out.println(driver.getTitle());
        // ilk sayfaya gecip url'i yazdiralim
        System.out.println(driver.switchTo().window(wHandle).getCurrentUrl());
        //ilk sayfaya gecip title'i yazdiralim
        System.out.println(driver.getTitle());
    }
   @After
    public void close(){
       driver.close();
   }
   @Before
    public void start(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }

}
