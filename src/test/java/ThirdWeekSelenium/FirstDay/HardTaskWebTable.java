package ThirdWeekSelenium.FirstDay;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Calendar;
import java.util.List;

public class HardTaskWebTable extends TestBase {
    @Test
    public void test(){

        //   QA HTML Table Task
        //1. get https://www.techlistic.com/p/demo-selenium-practice.html
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.xpath("//*[@id=\"cookieChoiceDismiss\"]")).click();
        //2. Structure tablosuna git (print head)
        driver.findElements(By.xpath("//table//thead//tr")).stream().forEach(t-> System.out.println(t.getText()));
        highestFunction();
        structercInform();
        oldestStructer();
        //8. Tablodaki son kolonun hücrelerinin boş olduğunu doğrula
        boolean empty=driver.findElements(By.xpath("//table[@border=\"1\"]//tbody//tr//td[6]")).stream().allMatch(t->t.getText().length()==0);;
        Assert.assertTrue(empty);

    }

    private void oldestStructer() {
        //7. Tablodaki en eski yapının sıralamadaki yerini yazdır
        List<WebElement> oldestStructures=driver.findElements(By.xpath("//table[@border='1']//tbody//tr//td[4]"));
        int currentYear= Calendar.getInstance().get(Calendar.YEAR);
        int oldest=oldestStructures.stream().mapToInt(t-> currentYear-Integer.parseInt(t.getText().replaceAll("[^0-9]",""))).max().getAsInt();
        int oldestYear=oldestStructures.stream().mapToInt(t-> Integer.parseInt(t.getText().replaceAll("[^0-9]",""))).min().getAsInt();
        System.out.println( "Oldest structer year is : " +oldestYear);
        List<WebElement> allStructures=driver.findElements(By.xpath("//table[@border='1']//tbody//tr//th"));
        System.out.println("this oldest structers' old is: " + oldest );
        allStructures.stream().filter(t->t.getText().contains(String.valueOf(oldestYear))).forEach(t-> System.out.println(t.getText()));
    }

    private void structercInform() {
        //4. Tabloda kaç yapının bilgisi var adedini yazdır
        System.out.println("Tablodaki yapilarin sayisi : " + driver.findElements(By.xpath("//table[@border='1']//tbody//tr//td[4]")).size());
        System.out.println("tablodaki yapilarin isimleri \n===================");
        driver.findElements(By.xpath("//table[@border=\"1\"]// tbody//tr//th")).stream().forEach(t-> System.out.println(t.getText()));
        //5. Tablonun son satırının sadece 2 kolon içerdiğini doğrula
        //6. Tabloda yapı satırlarının kaç kolon içerdiğini yazdır
        int structuresFields=driver.findElements(By.xpath("//table[@border=\"1\"]//thead//th")).size();
        System.out.println("Structures fields are : " + structuresFields );
        //9. Yapıların isim listesini başlığıyla birlikte yazdır
        driver.findElements(By.xpath("//table[@border=\"1\"]// tbody//tr")).stream().forEach(t-> System.out.println(t.getText() + "  "));
    }
    private void highestFunction() {
        //3. En uzun yapının yasini ve bilgilerini yazdır
        int structureTableSize=  driver.findElements(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tbody/tr")).size();
        System.out.println(structureTableSize);
        List<WebElement> highStructures=driver.findElements(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tbody/tr/td[3]"));
        highStructures.stream().forEach(t-> System.out.println(t.getText().replaceAll("[^0-9]","")));
        int highest= highStructures.stream().mapToInt(t-> Integer.parseInt(t.getText().replaceAll("[^0-9]",""))).max().getAsInt();
        System.out.println("Highest : " + highest);
    }
}
