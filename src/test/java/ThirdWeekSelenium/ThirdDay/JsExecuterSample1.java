package ThirdWeekSelenium.ThirdDay;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class JsExecuterSample1 extends TestBase {
    @Test
    public void test(){
        //2- hotelmycamp anasayfasina gidin 
        driver.get("https:/www.hotelmycamp.com");
        //3- 2 farkli test method’u olusturarak actions clasi ve
        actionType();
        jsExecutorType();
        //Js Executor kullanarak asagidaki oda turlerinden
        //ust sira ortadaki odayi tiklayin
        //4- istediginiz oda inceleme sayfasi acildigini test edin
    }

    private void jsExecutorType() {
        //javaScript
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement we= driver.findElement(By.xpath("//a[@href=\"/RoomDetail/209\"]\n"));
        js.executeScript("arguments[0].scrollIntoView(true)",we);
    }

    private void actionType() {
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).click(driver.findElement(By.xpath("//a[@href=\"/RoomDetail/209\"]\n"))).perform();
    }
}
