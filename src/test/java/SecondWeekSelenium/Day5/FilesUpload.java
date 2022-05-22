package SecondWeekSelenium.Day5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class FilesUpload extends TestBase {
    @Test
    public void Test1(){
        //https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
        //click to chooseFile button
        WebElement selectFile=driver.findElement(By.xpath("//input[@id='file-upload']"));
        //sendKeys()
        String uploadFile=System.getProperty("user.home") +"\\Downloads\\dummy.txt";
        selectFile.sendKeys(uploadFile);
        driver.findElement(By.xpath("//input[@class='button']")).click();
        //File Uploaded! if is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
