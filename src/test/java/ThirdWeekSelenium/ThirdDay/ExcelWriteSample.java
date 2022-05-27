package ThirdWeekSelenium.ThirdDay;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriteSample extends TestBase {
    @Test
    public void test() throws IOException {

        driver.get("https://www.n11.com/");
        Actions action = new Actions(driver);
        driver.findElement(By.id("myLocation-close-info")).click();
        driver.findElement(By.xpath("(//button[@class='dn-slide-deny-btn'])[1]")).click();
        // TODO perform'u unutma!
        action.moveToElement(driver.findElement(By.xpath("//span[@title=\"Mağazalar\"]"))).perform();
        driver.findElement(By.linkText("Mağazaları Gör")).click();

        List<WebElement> linksA = driver.findElements(By.xpath("//*[@id=\"contentSellerList\"]/div/div[2]/div/div[2]/div[4]/div[2]/ul/li"));
        int listSize = linksA.size();
        //linksA.stream().forEach(t -> System.out.println(t.getText()));

        System.out.println(linksA.get(0).getText());
        String filePath = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis);

       /* for(int i = 0; i < linksA.size(); i++) {
            workbook.getSheet("Sheet1").createRow(i).createCell(0).setCellValue(linksA.get(i).getText());
        }*/

        //workbook.getSheet("Sheet1").getRow(0).createCell(0).setCellValue(linksA.get(0).getText());

        //FileOutputStream fos=new FileOutputStream(filePath);
        //workbook.write(fos);
        int excelRowSize=workbook.getSheet("Sheet1").getLastRowNum()+1;
        Assert.assertEquals(linksA.size(),excelRowSize);
        // String data = workbook.getSheet("Sheet1").getRow(3332).getCell(0).toString();
        // System.out.println(data);

        workbook.close();
        fis.close();
        //fos.close();


    }
}
