package SecondWeekSelenium.Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ABuradanbakDropDownsample2 {
    WebDriver driver;
    @Test
    public void test(){
        //amazona gidip dropDwon'dan books'u secip  java aratalim
        driver.get("https://www.amazon.com");
        // 1- dropdown menuyu locate edelim
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        // 2- select objesi olusuturp paraöetre olarak bir onceki adimda olusturdgumuz webelementi yazalim
        Select select=new Select(ddm);
        // 3- select claasından olsutdugumuz obje. yaptıktan sonra 3 tane method cıkıyor
            // select.selectByVisibleTest ____> gotunen yazıyla arama/cagırma
            // select.selectByIndex ------> kacıncı opsiyon
            // select.selectByValue------>value attribute'e gore cagirir
        select.selectByVisibleText("Books");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        //ve arama sonuclarının java icerdigini test edelim
        Assert.assertTrue("olmadi",driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]")).getText().contains("Java"));

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
