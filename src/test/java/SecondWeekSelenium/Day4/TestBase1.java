package SecondWeekSelenium.Day4;

import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

//import utilities.TestBase;//import etmemize ragmen griydi ama extends edince oldu
public class TestBase1 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // amazon anasayfaya gidecegiz
        driver.get("https://www.amazon.com");
        //amazonda  account meunusunden create a list'e click yapacagiz
        Actions action=new Actions(driver);
        WebElement account=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        action.moveToElement(account).perform();//hedef yere gidiyoruz
        //create list'i locate edip click ile tikliyoruz
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        Thread.sleep(3000);
    }
}
