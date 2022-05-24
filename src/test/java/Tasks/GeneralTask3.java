package Tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import javax.swing.*;

public class GeneralTask3 extends TestBase {
    @Test
    public void tets(){
        //1. rediff.com'a git. ("https://www.rediff.com/")
        driver.get("https://www.rediff.com/");
        String firstHandle= driver.getWindowHandle();
        //2. Logonun görünür olduğunu doğrula.
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]")).isEnabled());
        //3. Top menüden Money'e tıkla.
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
        //4. MARKETS başlığı altında NSE sekmesine tıkla. (BSE aktif.)
        Actions action=new Actions(driver);
        action.click(driver.findElement(By.xpath("//*[@id=\"sensTab1\"]"))).sendKeys(Keys.TAB).click().perform();
        //5. GAINERS içinde birincinin kazancının %5'ten fazla olduğunu kontrol et.
        String  refound=driver.findElement(By.xpath("//*[@id=\"bseGainerDiv\"]/div[1]/div[3]")).getText();
        int firstPerctage=Integer.parseInt(refound.replaceAll("[^0-9]",""));
        Assert.assertTrue(firstPerctage>5);
        //6. SECTORAL INDICES altında METAL'in puanını konsola yazdır. Düne göre kazançlı mı diye kontrol et.
        System.out.println("Mteal Poit is: " + driver.findElement(By.xpath("//*[@id=\"metal\"]/h5")).getText());
        //7. METAL'e tıkla
        driver.findElement(By.xpath("//*[@id=\"metal\"]")).click();
        //8. Açılan sayfada grafik üzerindeki başlığın "companies" içerdiğini kontrol et.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/div[1]/span[2]")).getText().contains("companies"));
        //9. Select Indice açılır menüsündeki option sayısının 10'dan büyük olduğunu kontrol et. Adedini konsola yazdır.
        WebElement ddm=driver.findElement(By.xpath("//*[@id=\"indices-sectoral\"]/div/div[2]/select"));
        Select select=new Select(ddm);
        int allOptions=select.getOptions().size();
        System.out.println(allOptions);
        Assert.assertTrue(allOptions>10);
        //10. Option'lardan BSE 100'ü seç.
        select.selectByVisibleText("BSE-100");
        //11. Açılan sayfada BSE 100 puanını konsola yazdır. Düne göre kazançlı olduğunu kontrol et.
        System.out.println("BSE-100 point : " + driver.findElement(By.xpath("//*[@id=\"ltpid\"]")).getText());
        //12 ilk sayfaya don
        driver.switchTo().window(firstHandle);
        //title'in icinde "Indian Market" kontrol et
        Assert.assertTrue(driver.getTitle().contains("Indian Market"));
    }
}
