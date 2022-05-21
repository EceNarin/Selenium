package FirstWeekSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BeforAfterJUnit {
    WebDriver driver;
    @Before
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void gapat(){
        driver.close();
    }
    @Test
    public void first(){
        driver.get("https://www.twitter.com");
    }
    @Test
    public void second(){
        driver.get("https://www.amazon.com");
    }
    @Test
    public void third(){
        driver.get("https://www.facebook.com");
    }
}
