package SecondWeekSelenium.Day6;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class ExplicitWaitTask extends TestBase {
    @Test
    public void Test(){
        //https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        //It's Gone
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(12));
        WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(text.isDisplayed());
        //click enable
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();
        //test to It's enabled!
        WebElement text2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(text2.isDisplayed());

    }
}
