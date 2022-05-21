package SecondWeekSelenium.Day4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsampleBasic extends TestBase {
    @Test
    public void test(){
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("http://www.amazon.com");
        driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")).click();
        //3- Arama kutusuna actions method’larine kullanarak
        WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        //samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        Actions action=new Actions(driver);
        action.click(searchBox).sendKeys("Samsung A71" + Keys.ENTER).perform();
        //4- aramanin gerceklestigini test edin
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]")).equals(null));

    }

}
