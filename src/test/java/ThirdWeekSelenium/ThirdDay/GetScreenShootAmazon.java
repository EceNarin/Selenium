package ThirdWeekSelenium.ThirdDay;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetScreenShootAmazon extends TestBase {
    @Test
    public void test() throws IOException {
        //if we dont wanna create manually source for copy to sscreenshot day by dy we can make it dinamic by dateTime
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);
        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        TakesScreenshot ts= (TakesScreenshot) driver;
        File file=new File("target/AmazonScreenShoot/shoots"+tarih+".jpeg");//goruntuyu kaydedecegimiz yer
        File temp=ts.getScreenshotAs(OutputType.FILE);//aldigimiz ekran goruntusu butun ekran
        FileUtils.copyFile(temp,file);
        //2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        //Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.amazon.com"));
        //3- Nutella icin arama yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        //4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText().contains("Nutella"));
        driver.findElement(By.xpath("//img[@data-image-index=\"1\"]")).click();
        WebElement we= driver.findElement(By.xpath("//img[@data-a-image-name=\"landingImage\"]"));
        File temp2=we.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp2,file);
    }
}
