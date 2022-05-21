package SecondWeekSelenium.Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IFrameTask {
    static WebDriver driver;





    @Test
    public void IFrame(){
        //   ● https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
        //   ● Bir metod olusturun: iframeTest
        //      ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin //*[@id="content"]/div/h3
        boolean iframeDisplayed=driver.findElement(By.xpath("//h3")).isDisplayed();
        Assert.assertTrue(iframeDisplayed); //passed
        //      ve  konsolda    yazdirin.
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        //      ○ Text Box’a “Merhaba Dunya!” yazin.
        // driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).sendKeys("Merhaba Dunya!");
        // textbox'i dogru olarak locate etmemize ragmen driver bulamadi
        // bunun uzerine HTML kodlari inceleyince
        // textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
        // bu durumda once iframe'i locate edip //*[@id="mce_0_ifr"]
        // switchTo() ile o iFrame'e gecmeliyiz
        WebElement iFrameElementi=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameElementi);
        //we are in iframe we can reach of textbox
        WebElement textbox=driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        //clean to textbox
        textbox.clear();
        //send words via sendkeys method to textbox
        textbox.sendKeys("Merhaba Dunya!");
        //      ○ TextBox’in altinda bulunan “Elemental Selenium”
        //      linkinin textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
        //driver.switchTo().frame(iFrameElementi); frame'e gectik
        //driver.switchTo().defaultContent(); frame'den cıktık
        // link yazi elementini dogru locate etmemize ragmen yazdirmadi
        // cunku yukarida iFrame'e gecis yapmistik
        // once oradan cikmamiz lazim
        driver.switchTo().defaultContent();
        //we are outside to iframe
        boolean isDis= driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a")).isDisplayed();
        Assert.assertTrue("dogru",isDis);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a")).getText());

    }
    @BeforeClass
    public static void open(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void close(){
    //driver.quit();
}
}
