package SecondWeekSelenium.Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDownSample3 {
    WebDriver driver;
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        //ddm objesi olusturuyoruz web elmentten sonra bu objeyi select obejesi olusturkren select() parametresine yazyrz
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");
        //dropDown'da son secilen option'a ulasmak isterseniz getfrstselection demek lazım
        //yaazdırmak icin web element cinsinden donen degeri gettext ile yazdırabiliriz
        System.out.println(select.getFirstSelectedOption().getText());//Books
        //drop down toplam optionslari yazıdracaz
        System.out.println(select.getOptions().size());
        int actualSize=select.getOptions().size();
        int expectedSize=20;
        Assert.assertEquals("not equals",expectedSize,actualSize);

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
        driver.quit();

    }
}
