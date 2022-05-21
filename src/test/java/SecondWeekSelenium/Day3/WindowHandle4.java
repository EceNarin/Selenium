package SecondWeekSelenium.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandle4 {
    WebDriver driver;
    @Test
    public void test() {
        //go to amazon
        driver.get("https://www.amazon.com");
        //save handlewindow value as string
        String amazonHandle=driver.getWindowHandle();
        System.out.println("amazon");
        driver.getWindowHandles().stream().forEach(t-> System.out.println(t +" "));
        System.out.println("amazonhandle" +amazonHandle);
        //test it if title have amazon inside or not
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //open new tab via and go ("https://www.techproeductaion.com")
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        System.out.println("tehcpor");
        driver.getWindowHandles().stream().forEach(t-> System.out.println(t +" "));
        String techproHandle=driver.getWindowHandle();//we can use and save any site handle then use and turn eachother
        System.out.println("techprohandle"+ techproHandle);
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATİON"));
        //OPEN NEW Window
        driver.switchTo().newWindow(WindowType.WINDOW);//type.Window will opel new window
        driver.get("http://www.walmart.com");
        System.out.println("walmarrt");
        driver.getWindowHandles().stream().forEach(t-> System.out.println(t +" "));
        System.out.println("walmartHandle"+ driver.getWindowHandle());
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
        driver.switchTo().window(amazonHandle);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.amazon.com/"));

    }
    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void close(){
        driver.close();
    }

}
