package ThirdWeekSelenium.FirstDay;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static sun.security.jgss.GSSUtil.login;

public class WebTablesTask2 extends TestBase {
    @Test
    public void  test(){
        //● login( ) metodun oluşturun ve oturum açın.
        login1();
    }

    private void login1() {
        //● https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com");
        //○ Username : manager ○ Password : Manager1!
        driver.findElement(By.xpath("(//a[@class=\"nav-link\"])[7]")).click();
        Actions action=new Actions(driver);
        action.click(driver.findElement(By.xpath("//input[@id=\"UserName\"]"))).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!")
        .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //table() methodu olusturun
       table1();
    }

    private void table1() {

        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        System.out.println(driver.findElements(By.xpath("//table//tr[1]/th")).size());
        //○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        System.out.println("ALL BODY");
        driver.findElements(By.tagName("table")).stream().forEach(t-> System.out.println(t.getText()));
        System.err.println("Baslik ");
        driver.findElements(By.xpath("//table//tr[1]/th")).stream().forEach(t-> System.out.println(t.getText()));
        //printRows() methodu olusturun
        printRows();
    }

    private void printRows() {
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println(" Count row" + driver.findElements(By.xpath("//table//tr")).size());
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        driver.findElements(By.xpath("//table//tr")).stream().forEach(t-> System.out.println(t.getText()));
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        driver.findElements(By.xpath("//table//tr[4]//td")).stream().forEach(t-> System.out.println(t));
        //● printCells( ) metodu oluşturun //td
        printCells();

    }

    private void printCells(){
        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        System.out.println("Total Cell nums of : " +driver.findElements(By.xpath("//table//tr//td")).size());
        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        driver.findElements(By.xpath("//table//tr//td")).stream().forEach(t-> System.out.println("All cells are : " + t.getText()));
        //● printColumns( ) metodu oluşturun
        printColums();
    }

    private void printColums() {
        //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        System.out.println("Total colums nums of : " + driver.findElements(By.xpath("//table//tr[1]/th")).size());
        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        driver.findElements(By.xpath("//table//tr[1]/th")).stream().forEach(t-> System.out.println(t.getText()));
        //○ 5.column daki elementleri konsolda yazdırın.
        driver.findElements(By.xpath("//table//tr[1]/th")).stream().forEach(t-> System.out.println(t));
    }
}
