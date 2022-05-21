package SecondWeekSelenium.Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AllertTask {
    static WebDriver driver;
    @BeforeClass
    public static void start(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public  void close(){
        driver.quit();
    }
    @Before
    public void start2(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
       driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
       driver.switchTo().alert().accept();
      String actualWord=driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
      String expectedWord="You successfully clicked an alert";
       Assert.assertEquals(expectedWord,actualWord);
        }
    @Test
    public void dissmissAllert(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
        driver.switchTo().alert().dismiss();
        String actualWord=driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        String expectedWord="successfully";
        Assert.assertNotEquals(expectedWord,actualWord);
    }
    @Test
        public void sendKeysAllert(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        driver.switchTo().alert().sendKeys("ece");
        driver.switchTo().alert().accept();
        String actualWord=driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        String expectedWord="ece";
        Assert.assertNotEquals(expectedWord,actualWord);

    }
}
