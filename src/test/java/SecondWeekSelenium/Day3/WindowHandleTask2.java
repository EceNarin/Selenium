package SecondWeekSelenium.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandleTask2 {
    WebDriver driver;
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void after(){
   driver.quit();
    }
    @Test
    public void test(){
// 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
       String amazonHandle= driver.getWindowHandle();
// 2- url'in  amazon icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
// 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");
        String bbyHandle=driver.getWindowHandle();
// 4- title'in BestBuy icerdigini test edelim
        Assert.assertFalse(driver.getTitle().contains("BestBuy"));
// 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java" + Keys.ENTER);
// 6- arama sonuclarinin Java icerdigini test edelim
      Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains("java"));
// 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(bbyHandle);
// 8- logonun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());
    }
}
