package SecondWeekSelenium.Day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class KeywordsLoginFaceBook extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //go to facebook mainpage
        driver.get("https://www.facebook.com/");
        //click to new account
         driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //locate to namebox
        WebElement nameBox=driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-\'])[1]"));
        //without mouse action move to another box with tab
        Actions action=new Actions(driver);
        Thread.sleep(3000);
        WebElement submit=driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _6o _6v']"));
        action.click(nameBox).sendKeys("ece").sendKeys(Keys.TAB).sendKeys("narin").sendKeys(Keys.TAB).sendKeys("ece@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("ece@gmail.com").sendKeys(Keys.TAB).sendKeys("123445").perform();
        WebElement day=driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select selectday=new Select(day);
        selectday.selectByIndex(23);
        Select selectmonth=new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
        selectmonth.selectByVisibleText("Oca");
        Select selectYear=new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
        selectYear.selectByValue("1990");
        driver.findElement(By.xpath("(//label[@class='_58mt'])[1]")).click();
        submit.click();
        //fill the form
    }
}
