package FirstWeekSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SampleThree {
    WebDriver driver;
    @Before
   public void before(){
        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
   @After
   public void close(){
       driver.close();
   }
   @Test
   public void test(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        WebElement firstt=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        String first=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        firstt.click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        if(driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText().equals(first)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }


   }

}
