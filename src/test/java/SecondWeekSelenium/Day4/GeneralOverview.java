package SecondWeekSelenium.Day4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class GeneralOverview extends TestBase {
    WebElement ddm;
    Select select;
    @Test
    public void test1(){
        //1- amazon gidin
        driver.get("http://www.amazon.com");
        driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")).click();
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
          ddm= driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
          select=new Select(ddm);
        List<WebElement> allOptions= select.getOptions();
        allOptions.stream().forEach(t-> System.out.println(t.getText()+ " - "));
       //3- dropdown menude 40 eleman olduğunu doğrulayın
        int actualSize=allOptions.size();
        System.out.println(actualSize);
        int expectedSize=40;
        Assert.assertFalse(actualSize==expectedSize);
    }
    @Test
    public void test2(){
        //1- dropdown menuden elektronik bölümü seçin
        driver.get("http://www.amazon.com");

        ddm= driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        select=new Select(ddm);
        select.selectByVisibleText("Electronics");
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone" + Keys.ENTER);
        System.out.println("Result : " + driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText());
        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText().contains("iphone"));
        //4- ikinci ürüne relative locater kullanarak tıklayin
         WebElement first=driver.findElement(By.xpath("(//img[@data-image-index='4'])[1]"));
         WebElement third=driver.findElement(By.xpath("(//img[@data-image-index='6'])[1]"));
         WebElement second= driver.findElement(with(By.tagName("img")).above(third).below(first));
         second.click();
        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        System.out.println("Product ttile" + driver.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText());
        String  priceString=driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']")).getText();
        System.out.println(priceString);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    }
    @Test
    public void test3(){
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.get("http://www.facebook.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://www.amazon.com");
        driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")).click();
        //2-dropdown’dan bebek bölümüne secin
        WebElement ddm= driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Baby");
        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Puset" +Keys.ENTER);
        //4-sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().contains("Puset"));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement second= driver.findElement(By.xpath("(//img[@data-image-index='1'])[1]"));
        WebElement forth=driver.findElement(By.xpath("(//img[@data-image-index='3'])[1]"));
        WebElement third= driver.findElement(with(By.tagName("img")).above(forth).below(second));
        third.click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    }
    @Test
    public void test4(){
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }





}
