package Challenge;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class Challenge1 extends TestBase {
    @Test
    public void test(){
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna "standard_user" yazdirin
        //3. Password kutusuna "secret_sauce" yazdirin
        Actions action=new Actions(driver);
        action.click(driver.findElement(By.xpath("//input[@id='user-name']"))).sendKeys("standard_user")
        .sendKeys(Keys.TAB).sendKeys("secret_sauce").perform();
        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
       String firstProduct=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
       driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText().equals(firstProduct));
        //9. Sayfayi kapatin
    }
}
