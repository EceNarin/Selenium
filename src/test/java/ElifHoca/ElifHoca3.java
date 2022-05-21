package ElifHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElifHoca3 {
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void after(){
        driver.close();
    }
    @Test
    public void Test(){
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        //fill the firstname
        driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div/div/h2[2]/div[1]/div/div[2]/input")).sendKeys("ece");
        //fill the lastname
        driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div/div/h2[2]/div[1]/div/div[5]/input")).sendKeys("nar");
        //check the gender
        driver.findElement(By.xpath("//*[@id=\"sex-1\"]")).click();
        //check the experience
        driver.findElement(By.xpath("//*[@id=\"exp-2\"]")).click();
        //fill the date
       driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).sendKeys("12-06-2022");
        //choose your profession -> Automation Tester
        driver.findElement(By.xpath("//*[@id=\"profession-1\"]"));
        //choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//*[@id=\"tool-2\"]"));
        //choose your continent -> Antartica
        driver.findElement(By.xpath("//*[@id=\"continents\"]")).sendKeys("Antartica");
        //choose your command  -> Browser Commands
        driver.findElement(By.xpath("//*[@id=\"selenium_commands\"]/option[1]"));
        //click submit button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

    }
}
