package SecondWeekSelenium.Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class IFrameTest2 {
    WebDriver driver;
    @Test
    public void test(){
        driver.get("http://demo.guru99.com/test/guru99home/");
        //find of total nums of iframe elements
       List<WebElement> iFrameList= driver.findElements(By.xpath("//iframe"));
        System.out.println(iFrameList.size());
        //click first utube iframe elementsd

        // get off from iframe come main page
        // at second iframe (Jmeter Made Easy), to link (htpss://www.guru99.com/live-selenium-project.html) and click

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
    //driver.close();
    }
}
