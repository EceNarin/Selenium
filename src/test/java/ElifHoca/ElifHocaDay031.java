package ElifHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.web.WebEngine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElifHocaDay031 {
    WebDriver driver;
@Before
    public void start(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@Test
    public void test(){
    // Navigate to website  https://testpages.herokuapp.com/styled/index.html
    driver.get("https://testpages.herokuapp.com/styled/index.html");
    // Under the  ORIGINAL CONTENTS
    //JavascriptExecutor js=new ChromeDriver();
    //js.executeScript("window.scrollBy(0,1000)");
    // click on Alerts
    // print the URL
    // navigate back
    // print the URL
    // Click on Basic Ajax
    // print the URL
    // enter value-> 20 and Enter
    // and then verify Submitted Values is displayed open page
    // close driver

}
 @After
    public void close(){
    //driver.close();
 }
}
