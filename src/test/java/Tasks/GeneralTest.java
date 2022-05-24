package Tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class GeneralTest extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1.https://the-internet.herokuapp.com/ sitesine git
        driver.get("https://the-internet.herokuapp.com/");
        String thisHandle= driver.getWindowHandle();
        //2.drag and drop'a mouse action ile sag tiklatip yeni sekmede acalim
        Actions action=new Actions(driver);
        action.keyDown(Keys.LEFT_CONTROL).click(driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[10]/a"))).keyUp(Keys.LEFT_CONTROL).perform();
        String newHandle="";
        for (String x: driver.getWindowHandles()) {
            if(!x.equals(thisHandle)){
                newHandle=x;
            }
        }
        driver.switchTo().window(newHandle);
        //3.drag and drop islemini yap mouse action ile
        action.click(driver.findElement(By.xpath("//*[@id=\"content\"]"))).dragAndDrop(driver.findElement(By.cssSelector("#column-a")), driver.findElement(By.cssSelector("#column-b"))).perform();
        //4. degisen degerleri test et
        String past=driver.findElement(By.xpath("//*[@id=\"column-a\"]/header")).getText();
        String new1=driver.findElement(By.xpath("//*[@id=\"column-b\"]/header")).getText();
        Assert.assertNotEquals(past,new1);
        //5.Elemental Selenium ile yeni acilan sekmenin windowhandle degerini yaz
        driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a")).click();
        String thirdHndle="";
        for (String x: driver.getWindowHandles()) {
            if(!x.equals(thisHandle)&& !x.equals(newHandle)){
                thirdHndle=x;
            }
            System.out.println(x);
        }
        driver.switchTo().newWindow(WindowType.TAB).switchTo().window(thirdHndle);
        Thread.sleep(3000);
        System.out.println("New Selenium Window Haandle is : " + thirdHndle);
        //6.ponsored by Sauce Labs'a tikla
        driver.findElement(By.xpath("/html/body/header/div/div/p/a")).click();
        String forthHandle="";
        for (String x: driver.getWindowHandles()) {
            if(!x.equals(thisHandle)&& !x.equals(newHandle)&& !x.equals(thirdHndle)){
                forthHandle=x;
            }
            System.out.println(x);
        }
        driver.switchTo().newWindow(WindowType.TAB).switchTo().window(forthHandle);
        //7.fareyle contact'in üzerine gelip contact support'u tikla
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"headerMainNav\"]/div/nav/ul/li[1]/ul[2]/li[6]/div[1]/div/a")))
        .click(driver.findElement(By.xpath("//*[@id=\"headerMainNav\"]/div/nav/ul/li[1]/ul[2]/li[6]/div[2]/div/div/div/ul/li/div/ul/li[2]/div/ul/li[1]/div/ul/li/a/span"))).perform();
        //8.ilk sayfaya geri gel
        driver.switchTo().window(thisHandle);

    }
}
