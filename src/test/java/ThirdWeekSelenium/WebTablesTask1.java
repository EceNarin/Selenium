package ThirdWeekSelenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class WebTablesTask1 extends TestBase {
    @Test
    public void login( ){
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin  //○ Username : manager  //○ Password : Manager1!
          driver.get("https://www.hotelmycamp.com");
          driver.findElement(By.xpath("(//a[@class=\"nav-link\"])[7]")).click();
          Actions action=new Actions(driver);
          action.click(driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"))).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!")
          .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //● table( ) metodu oluşturun //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        System.out.println(driver.findElement(By.xpath("//*[@id=\"datatable_ajax\"]")).getSize());
        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        System.err.println("All table ");
        driver.findElements(By.tagName("table")).stream().forEach(t-> System.err.println(t.getText() + " - "));
        driver.findElements(By.xpath("//*[@id=\"datatable_ajax\"]/thead/tr[1]")).stream().forEach(t-> System.err.println("All Header for Column : " +t.getText()+" , "));
        //● printRows( ) metodu oluşturun //tr
        long row=driver.findElements(By.tagName("tr")).stream().filter(t-> !t.getAttribute("class").equals("heading") && !t.getAttribute("class").equals("filter")).count();
        System.out.println("Row count is : " + row);
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.err.println("column count is : " + driver.findElements(By.tagName("th")).size());
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        driver.findElements(By.tagName("th")).stream().forEach(t-> System.out.println("All Rows are Head : " + t.getText()));
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        driver.findElements(By.tagName("th")).stream().forEach(t-> System.err.println("All Rows are : " + t ));
    }
}
