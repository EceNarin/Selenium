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

public class ElifHocaDay022 {
    WebDriver driver;
       @Test
    public void test(){
           //http://www.bestbuy.com 'a gidin,
           driver.get("http://www.bestbuy.com");
           //Sayfa basliginin "Best" icerdigini(contains) dogrulayin
           boolean ifHave=driver.getTitle().contains("Best")?true:false;
           //logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
          boolean logotest= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/img")).isDisplayed();
           System.out.println(logotest);
          //mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
          boolean link=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/a[3]")).isDisplayed()?true:false;
           System.out.println(link);
          // Assert.assertEquals("mexicoLinkTest",driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/a[3]")).getText());
       }
       @Before
    public void before(){
           WebDriverManager.chromedriver().setup();
           driver=new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
       }
       @After
       public void after(){
           driver.quit();
       }
}
