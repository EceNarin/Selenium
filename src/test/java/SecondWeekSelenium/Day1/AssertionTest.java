package SecondWeekSelenium.Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AssertionTest {
    WebDriver driver;
    @Test
    public void test(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("(//input[@*='is_required validate account_input form-control'])[1]")).sendKeys("ece.gmaail.com"+ Keys.ENTER);
       Assert.assertEquals("Tutmadi","Invalid email address",driver.findElement(By.xpath("//*[text()='Invalid email address.']")).getText());


    }
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void close(){
        driver.quit();
    }
}
