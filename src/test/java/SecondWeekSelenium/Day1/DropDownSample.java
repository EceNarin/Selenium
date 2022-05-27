package SecondWeekSelenium.Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownSample {
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
    driver.quit();
    }
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
       WebElement dd= driver.findElement(By.xpath("//*[@id=\"dropdown\"]"));
        Select select=new Select(dd);
        //indeexe gore optıon yazdırılır
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //html kodunda value= karsıında yazan degeri yazacaz
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //dropdown'da gorunen yazıya gore secme
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //getfirstselectoption bir oncekını yazdırır
        //butun optionslar yazdırılır
        List<WebElement> ddList=select.getOptions();
        ddList.toString();
        ddList.stream().forEach(t-> System.out.print(t.getText() +","));
        int ddActualSize= ddList.size();
        int expectedSize=3;
        Assert.assertEquals(expectedSize,ddActualSize);
        if(expectedSize==4){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }

    }
}
