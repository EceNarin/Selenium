package SecondWeekSelenium.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandleSS3 {
    WebDriver driver;
    @Test
    public void test(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
       Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains("Opening a new window"));
        String firstHandleValue=driver.getWindowHandle();
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String scwh="";
        Set<String> secondWindwoHandles=driver.getWindowHandles();
        for (String handle:secondWindwoHandles) {
            if(!handle.equals(firstHandleValue)){
                scwh=handle;

            }
        }
        driver.switchTo().window(scwh);
        Assert.assertEquals("New Window",driver.getTitle());
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().equals("New Window"));
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(firstHandleValue);
        Assert.assertEquals("The Internet",driver.getTitle());
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
