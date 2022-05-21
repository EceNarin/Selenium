package SecondWeekSelenium.Day4;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class ActionClasssSample1 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        ////move to element ile o like gidiyruz
        //action.doubleClick().perform();  //dont forget to put  .perform() method
        //action.clickAndHold().perform();//webeementt uzerinde click ederek bizden komut bekler
        //action.dragAndDrop().perform(); //surukleyirip bırakma
        //action.movetoElement().perform();//hedef webleemtn ustune gider
        //action.contextClick().perform();//mouse ile stedigimiz weblement'e sagtiklama yapar

        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String thisHandle=driver.getWindowHandle();
        System.out.println("thisHandle" + thisHandle);
        //3- Cizili alan uzerinde sag click yapalim
        WebElement one=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions action=new Actions(driver);
        action.moveToElement(one).contextClick().perform();
        Thread.sleep(1500);
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualAlert=driver.switchTo().alert().getText();
        String expectedAlert="You selected a context menu";
        Assert.assertEquals(expectedAlert,actualAlert);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        Thread.sleep(1500);
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> newWindow=driver.getWindowHandles();
        //String anotherHandle=newWindow.stream().filter(t-> !t.equals(thisHandle)).toString();
        String anotherHandle="";
        for (String x:newWindow) {
            if(!x.equals(thisHandle)){
                anotherHandle=x;
            }
        }
        System.out.println(anotherHandle);
        driver.switchTo().window(anotherHandle);
        String actualWords= driver.findElement(By.xpath("/html/body/header/div/div/h1")).getText();
        String expectedWords="Elemental Selenium";
        Assert.assertEquals(expectedWords,actualWords);



    }
}
