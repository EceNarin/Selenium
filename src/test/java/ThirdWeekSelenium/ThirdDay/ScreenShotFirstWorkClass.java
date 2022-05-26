package ThirdWeekSelenium.ThirdDay;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class ScreenShotFirstWorkClass extends TestBase {
    @Test
    public void shTest() throws IOException {
        //1- go to amazon'a
        driver.get("https://www.amazon.com/");
                 // FIRST PART: HOW TO TAKE SCREEN SHOT SPECİFİC ELEMENTS AND SAVE
        //A- To make web element to locate

        //2- Create a takescreenshot object and cast to driver object to  as takescreenshot data type
            TakesScreenshot ts= (TakesScreenshot) driver;

        //3- take target file path whic is stay in project bottom and create file object fromFile class Apache.Io
            //and put this file's path in File class's constructor as String
            File    file= new File("target/ScreeShoot/AllPages.jpg");

        //4- using by TakeScreenShot object voke to getScreenshot() function and assign to this result a temporal conteiner
           //which is data type comes from file NOTES: dont forget to put  OutputType's interface's static final variable OutputType.FILE
            File temp=ts.getScreenshotAs(OutputType.FILE);

        //5- get copy and paste this temporal variable's to which our target places
            FileUtils.copyFile(temp,file);

        //B- Create a new file which will your screnshots for stores
        //C- Work getScreenshotAs method on by your weblement and put in temporal file in by assign
            File temp1=ts.getScreenshotAs(OutputType.FILE);

        //D- Copy your temp and send to for store your temporal files your screenshot store whic is name we created as file above target file
           FileUtils.copyFile(temp1,file);








    }
}
