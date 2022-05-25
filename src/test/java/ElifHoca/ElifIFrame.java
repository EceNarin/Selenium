package ElifHoca;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class ElifIFrame extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"emoojis\"]")));
        driver.findElement(By.xpath("(//span[@class=\"mdl-tabs__ripple-container mdl-js-ripple-effect\"])[2]")).click();
        // tüm ikinci emoji öğelerini tıklayın
        driver.findElements(By.xpath("//div[@id=\"nature\"]")).stream().forEach(t->t.click());
        // parent iframe e geri donun
        driver.switchTo().parentFrame();
        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        Actions action=new Actions(driver);
        Faker fake=new Faker();
        Thread.sleep(5000);
        action.click(driver.findElement(By.xpath("//input[@id=\"text\"]"))).sendKeys(fake.name().firstName()).sendKeys(Keys.TAB)
        .sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(fake.name().firstName()).sendKeys(Keys.TAB)
        .sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(fake.name().firstName()).sendKeys(Keys.TAB)
        .sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(fake.name().firstName()).sendKeys(Keys.TAB)
        .sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).click().perform();

        Thread.sleep(5000);
        //  apply button a basin
        driver.findElement(By.xpath("//*[@id=\"send\"]")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/div[14]/label")).getText());
    }
}
