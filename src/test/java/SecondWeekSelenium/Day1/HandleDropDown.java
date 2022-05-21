package SecondWeekSelenium.Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandleDropDown {
    WebDriver driver;
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //first of all i have to create a variable which is from webelemnt by xpath
        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        //create an object from select class and use ddm variable in select class constructor
        Select select=new Select(ddm);
        //using by index select option and print it
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        // using by value select option and print it
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //using by visibletext select option and print it
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
    }
    @After
    public void close(){
        driver.quit();
    }
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
