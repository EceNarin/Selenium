package ElifHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElifHocaDay023 {
 static WebDriver driver;
    @BeforeClass
    public static void start(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Before
    public void testtenOnce(){
        driver.get("http://www.google.com");
    }

    @Test
    public void test1(){
        //arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
     driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Green Mile"+ Keys.ENTER);

    }
    @Test
    public void test2(){
        //arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Premonition"+ Keys.ENTER);

    }
    @Test
    public void tes3(){
        //arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER);
    }
     @After
    public void testtenSonra(){
        System.out.println(driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText());
    }
    @AfterClass
    public static void close(){
        //AfterClass ile kapatın
       //driver.close();
        driver.quit();
    }
}
