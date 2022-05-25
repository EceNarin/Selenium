package ElifHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class ElifHocaExplicitlyWait extends TestBase {
    @Test
    public void test(){
        //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        //click on action dialog button
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(12));
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"action\"]"))); //if need use explicitly wait
        element.click();
        //click on the ok button
        driver.findElement(By.xpath("//*[@id=\"dialog-mycodemyway-action\"]")).click();
        //accept the alert message
        driver.switchTo().alert().accept();
    }
}
