package Challenge;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Challenge2 extends TestBase {
    @Test
    public void test(){
        //Notes: It may also be necessary to write code to accept the accept cookies warning.
        //1. Go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
        //driver.switchTo().alert().accept();
        //2. Search iPhone13 512
        Select select=new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
        select.selectByVisibleText("Elektronik");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512" + Keys.ENTER);
        //3. Check that the results are listed
        System.out.println(driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]")).getText());
        //4. Click iPhone13 at the top of the list
        driver.findElement(By.xpath("//img[@data-image-index='2']")).click();
        //5. Log the following values for each size
        String price=driver.findElement(By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span/span[2]/span[1]")).getText();
        int priceA=Integer.parseInt(price.replaceAll("[^0-9]",""));
        //.Size information .Price .Color .Stock status
        System.out.println(driver.findElement(By.xpath("//*[@id=\"feature-bullets\"]")).getText());
    }
}
