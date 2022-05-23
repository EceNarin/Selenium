package Tasks;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class WindowHandle extends TestBase {
    @Test
    public void Test(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String firstPageHandle=driver.getWindowHandle();
        String firstPageUrl=driver.getCurrentUrl();
        //2."Login Portal" a kadar asagi inin
        Actions action=new Actions(driver);
        action.sendKeys(Keys.DOWN).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//a[@id='login-portal']")).click();
        //4.Diger window'a gecin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://webdriveruniversity.com/Login-Portal/fail.html");
        //5."username" ve "password" kutularina deger yazdirin
        Faker fake=new Faker();
        action.click(driver.findElement(By.xpath("//input[@id='text']"))).sendKeys(fake.name().firstName()).perform();
        action.click(driver.findElement(By.xpath("//input[@id='password']"))).sendKeys(fake.internet().emailAddress()).perform();
        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        Assert.assertTrue(driver.switchTo().alert().getText().equals("validation failed"));
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(firstPageHandle);
        //10.Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(driver.getCurrentUrl().equals(firstPageUrl));
    }
}
