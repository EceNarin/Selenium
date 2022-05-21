package SecondWeekSelenium.Day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyWordBaseActions extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Point point=driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']")).getLocation();
         Actions action=new Actions(driver);
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        //4- videoyu izlemek icin Play tusuna basin //*[@id="movie_player"]/a   //div[@class='render']
        WebElement iframe=driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@id=\"movie_player\"]")).click();
        //5- videoyu calistirdiginizi test edin
    }
}
