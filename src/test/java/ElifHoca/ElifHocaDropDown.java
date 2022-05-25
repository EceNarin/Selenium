package ElifHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import sun.swing.SwingUtilities2;
import utilities.TestBase;

import java.security.Key;

public class ElifHocaDropDown extends TestBase {
    @Test
    public void test(){
   // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")).click();
        //driver.switchTo().alert().accept();
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        Select select=new Select(driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]")));
        select.selectByVisibleText("Books");
   //    kategorilerin hepsini konsola yazdiralim
        select.getOptions().stream().forEach(t-> System.out.println(t.getText()));
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Les Miserables" + Keys.ENTER);
   // 4. Sonuc sayisini ekrana yazdiralim.
        System.out.println("Print result : " +driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText());
   // 5. Sonucların Les Miserables i icerdigini assert edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText().contains("Les Miserables"));

    }
}
