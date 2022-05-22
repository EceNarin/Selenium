package SecondWeekSelenium.Day6;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class ImplicitlyWaitTasks extends TestBase {
    @Test
    public void Test(){
        //https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        //It's gone!
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
        //click add button
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();
        //It's gone!
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
    }
}
