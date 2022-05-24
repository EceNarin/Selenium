package ThirdWeekSelenium.FirstDay;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class WebTablesTask3 extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.hotelmycamp.com");

        //a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        //hücredeki(cell) veriyi yazdırmalıdır.

        //2. Baska bir Test metodu oluşturun: printDataTest( );
        printDataTest();
        //a. Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
        //b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
        //c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
    }

    private void printDataTest() {
        //1. Bir metod oluşturun : printData(int row, int column);
        int column = 0;
        int row = 0;
        printData(row, column);
    }

    public void printData(int x,int y){
        driver.findElements(By.xpath("//table//tr[x]//td[y]")).stream().forEach(t-> System.out.println(t.getText()));
    }
}
