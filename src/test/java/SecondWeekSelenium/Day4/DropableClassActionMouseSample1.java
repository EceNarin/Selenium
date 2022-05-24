package SecondWeekSelenium.Day4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class DropableClassActionMouseSample1 extends TestBase {
       @Test
    public void test() throws InterruptedException {
           //1- https://demoqa.com/droppable adresine gidelim
           driver.get("https://demoqa.com/droppable");
           Actions action=new Actions(driver);
           WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
           WebElement target=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
           //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
              Thread.sleep(3000);
           String actualPast=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
           System.out.println(actualPast);
              Thread.sleep(3000);
           action.dragAndDrop(source,target).perform();//don't forget to add perform() method as last
           //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

           String actualNew=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
           Thread.sleep(3000);
           System.out.println(actualNew);
           Assert.assertNotEquals(actualPast,actualNew);

       }
}
