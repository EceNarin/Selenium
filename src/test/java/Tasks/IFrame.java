package Tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class IFrame extends TestBase {
    @Test
    public void Test() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"frame\"]")));
        driver.findElement(By.xpath("//*[@id=\"div-main-nav\"]/div/ul/li[2]/a")).click();
        Thread.sleep(2000);
        //3. “Cameras product”i tiklayin
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//p[@class='sub-heading'])[1]")).click();
        //4. Popup mesajini yazdirin
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"frame\"]")));
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/p")).getText());
        Thread.sleep(2000);
        //5. “close” butonuna basin
        driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(2000);
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"nav-title\"]")).click();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl="http://webdriveruniversity.com/index.html";
        Assert.assertTrue(driver.getCurrentUrl().equals(expectedUrl));

    }
}
