package SecondWeekSelenium.Day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyWordActions extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        //first of all click to searchbox
        //then print to Nutella words char to char
         Actions action=new Actions(driver);
         //action.sendKeys() wee can send to words via this
         //action.keyDown() we can click to tab in keyword
         //action.keyUp() we can free to tabs
        action.click(searchbox)
                .keyDown(Keys.SHIFT)
                .sendKeys("n")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER).perform();

    }
}
