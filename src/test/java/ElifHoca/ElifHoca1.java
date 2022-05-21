package ElifHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElifHoca1 {
   WebDriver driver;
    @Before
    public void start(){
        // ...Exercise1...
        // Set Path
        // Create chrome driver
        // Maximize the window
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void close(){
        // Close/Quit the browser
        driver.close();

    }
    @Test
    public void test1() throws InterruptedException {
        // Open google home page https://www.google.com/
        //driver.get("https://www.google.com/");
        driver.navigate().to("https://www.google.com");
        Thread.sleep(1500);
        // On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
        //driver.get("https://www.amazon.com/");
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(1500);
        // Assert.assertTrue(driver.navigate().back()==driver.getCurrentUrl("https://www.amazon.com/"));
        Thread.sleep(1500);
        driver.navigate().back();
        // Navigate forward to amazon
        Thread.sleep(1500);
        driver.navigate().forward();
        // Refresh the page
        Thread.sleep(1500);
        driver.navigate().refresh();
        // And last step : print "all ok" on console
        System.out.println("All Ok");
    }
}
