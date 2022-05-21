package ElifHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ElifHocaDay021 {
   WebDriver driver;
    private WebDriver.Options manage;

    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.teknosa.com/ adresine
        driver.get("https://www.teknosa.com/");
    }
    @After
    public void close(){
        //driver i kapatiniz
        //driver.close();
        //driver.quit(); works same as same clsoe();
    }
    @Test
    public void test01(){

       ChromeOptions op = new ChromeOptions();
        op.addArguments("disable-popup-blocking");
      // driver.manage().deleteAllCookies();
      // driver.findElement(By.xpath("//div[@class='banner__accept-button']")).click();
      // type in searchbox oppo after+enter
        driver.findElement(By.xpath("//input[@id=\"search-input\"]")).sendKeys("oppo"+ Keys.ENTER);
        //print result
        System.out.println(driver.findElement(By.xpath("//*[@id=\"site-main\"]/div/div[1]/div[1]/div/div[1]/div[1]/div[1]")).getText());
        //choose first output
        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();
        //add to cart
        driver.findElement(By.xpath("//button[@id ='addToCartButton']")).click();
        //go to cart
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div[3]/a[2]")).click();
        //consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        System.out.println(driver.findElement(By.xpath("//*[@id=\"site-main\"]/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[1]")).getText());
        //Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//*[@id=\"site-main\"]/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div/div[2]/a")).click();
        //son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        System.out.println(driver.findElement(By.xpath("//*[@id=\"site-main\"]/div/div[1]/div[1]/div/div[1]")).getText());

    }

}
