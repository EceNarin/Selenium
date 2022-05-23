package Tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class GeneralTest2 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1-https://www.rediff.com/ istesine git
        driver.get("https://www.rediff.com/");
        String thisHandle= driver.getWindowHandle();
        System.out.println(thisHandle);
        //2.en alt sayfaya gelip bussines'i tikla
        Actions action=new Actions(driver);
        Thread.sleep(1500);
       // action.sendKeys(Keys.PAGE_DOWN).contextClick(driver.findElement(By.xpath("(//a[@class='backnews'])[1]"))).sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.PAGE_DOWN).click(driver.findElement(By.xpath("(//a[@class='backnews'])[1]"))).sendKeys(Keys.ENTER).perform();
        //3.geri gel
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.rediff.com/news");
        System.out.println(driver.getWindowHandle());
        driver.switchTo().window(thisHandle);
        //4.div conteiner'lar icinden tab yardimiyla searchbox kismina gelip dolar kurunu arat(yeni sekmeden acilacak handle degerini kaydet)
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='moneyiframe']")));
        //5.kur iframe'i icinde dolar'in guncel kurunu arat
        action.click(driver.findElement(By.xpath("(//input[@id='query'])[1]"))).sendKeys("USD" +Keys.ENTER).perform();
        String new1=driver.getWindowHandle();
        System.out.println(driver.getCurrentUrl());
        System.out.println(new1);
        Thread.sleep(3000);
        //6.cıkan sonucu yazidr-
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://money.rediff.com/companies/Ushdev-International-Ltd/14060213");
        System.out.println("currently USD: "+ driver.findElement(By.xpath("//*[@id=\"ltpid\"]")).getText() +"$");
        //8.reddif sitesine geri gel
        driver.switchTo().window(thisHandle);


    }
}
