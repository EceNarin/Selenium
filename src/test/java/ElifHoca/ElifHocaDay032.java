package ElifHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElifHocaDay032 {
    WebDriver driver;
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void close(){
        //9.  Tum sayfalari kapatiniz
       // driver.quit();
    }
    @Test
    public void test(){
        //1.  https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");
        //2.  Bir mail adersi giriniz
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("ece.m@gmail.com");
        //3.  Bir password giriniz
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1234");
        //4.  Login butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@id=\"login\"]/form/button")).submit();
        //5.  "There was a problem with your login." texti gorunur ise
        boolean what=driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]")).isDisplayed()?true:false;
        System.out.println(what);
        //6.  "kayit yapilamadi" yazdiriniz
        Assert.assertTrue("kayit yapilamadi",what);
        //8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        Assert.assertFalse("kayit yapıldi",what);

    }
}
