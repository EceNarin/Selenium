package ThirdWeekSelenium.FirstDay;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTablesTask4 extends TestBase {
    @Test
    public void test(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan department isimlerini yazdirin
        driver.findElements(By.xpath("//div[@class=\"rt-thead -header\"]")).stream().forEach(t-> System.out.println(t.getText()));
        //3. sutunun basligini yazdirin
        driver.findElements(By.xpath("//div[@role=\"columnheader\"]")).stream().forEach(t-> System.out.println(t.getText()));
        //4. Tablodaki tum datalari yazdirin
        System.out.println("All datas ");
        driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]")).stream().forEach(t-> System.out.println("dddd" +t.getText()));
        //5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("All cells size : " +driver.findElements(By.xpath("//div[@class=\"rt-tr\"]//div[//@class=\"rt-td\"]")).size());
        //6. Tablodaki satir sayisini yazdirin
        System.out.println("All row size" +driver.findElements(By.xpath("//div[@role=\"rowgroup\"]")).size());
        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("Column Size: " +driver.findElements(By.xpath("//div[@role=\"columnheader\"]")).size());
        //8. Tablodaki 3.kolonu yazdirin
        System.out.println( "Third row : "+ driver.findElement(By.xpath("(//div[@role=\"rowgroup\" ])[3]")).getText());
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
       int KieraaSalary=Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[3]/div/div[5]")).getText());
        System.out.println("Kierra salary is : " + KieraaSalary);
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
        findRowAndColumn();
        //girdigimde bana datayi yazdirsin
    }

    private void findRowAndColumn() {
        System.out.println("Column Size: " +driver.findElements(By.xpath("//div[@role=\"columnheader\"]")).size());
        System.out.println("All row size" +driver.findElements(By.xpath("//div[@role=\"rowgroup\"]")).size());
    }
}
