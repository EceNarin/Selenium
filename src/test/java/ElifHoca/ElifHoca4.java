package ElifHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElifHoca4 {
    WebDriver driver;
    @Test
    public void test(){
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        // Click on  Calculate under Micro Apps
        driver.findElement(By.xpath("//*[@id=\"calculatetest\"]")).click();
        // Type any number in the first input
        driver.findElement(By.xpath("//*[@id=\"number1\"]")).sendKeys("30");
        // Type any number in the second input
        driver.findElement(By.xpath("//*[@id=\"number2\"]")).sendKeys("100");
        // Click on Calculate
        driver.findElement(By.xpath("//*[@id=\"calculate\"]")).click();
        // Get the result
        String result= driver.findElement(By.xpath("//*[@id=\"answer\"]")).getText();
        // Print the result
        System.out.println(result);

    }
    @After
    public void after(){
        driver.close();
    }
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
