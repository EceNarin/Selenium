package Tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class GeneralTask4 extends TestBase {
    @Test
    public void Test() throws InterruptedException {
        //1. https://www.rediff.com/ istesine git
        driver.get("https://www.rediff.com/");
        String firstHandle= driver.getWindowHandle();
        //2. title'ın "Rediff" içerdiğini kontrol et.
        Assert.assertTrue(driver.getTitle().contains("Rediff"));
        //3. NSE'nin güncel puanını konsola yazdır. Düne göre yükselmiş mi diye kontrol et.
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"moneyiframe\"]")));
        System.out.println("NSE Current Point: " + driver.findElement(By.xpath("//*[@id=\"nseindex\"]")).getText());
        Assert.assertTrue("High Price",driver.findElement(By.xpath("(//span[@class='iconDown'])[1]")).getAttribute("class").equals("iconDown"));
        driver.switchTo().defaultContent();//get out off iframe shit
        //4. Haberler menüsünde HOME haricinde 8 eleman olduğunu doğrula.

        //5. Sayfayı aşağı kaydır.
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //6. Kare şeklindeki haberlerden ilk VIDEOS başlıklı olanı yeni sekmede aç.
        driver.findElement(By.xpath("//*[@id=\"red_container_main\"]/div[13]/h5/a")).click();
        String secondHandle="";
        for (String x: driver.getWindowHandles()) {
            if(!x.equals(firstHandle)){
                secondHandle=x;
            }
        }
        driver.switchTo().window(secondHandle);
        //7. Videonun oynatıldığını doğrula.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content_video\"]/div[4]/button[4]")).isEnabled());
        //8. ilk sayafaya dön.
        driver.switchTo().window(firstHandle);
        Thread.sleep(15000);
        //9. Haber menüsünden COVID-19'a tıkla.
        driver.get("https://www.rediff.com/");
        driver.findElement(By.xpath("/html/body/div[5]/ul/li[9]/a")).click();
        Thread.sleep(15000);
        //10. Açılan sayfadaki haberlerin üzerinde başlık olarak "THE WAR AGAINST CORONAVIRUS" yazdığını doğrula.
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("THE WAR AGAINST CORONAVIRUS"));
    }
}
