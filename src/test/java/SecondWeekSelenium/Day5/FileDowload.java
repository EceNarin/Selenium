package SecondWeekSelenium.Day5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDowload extends TestBase {
    @Test
    public void test(){
        //https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
        //code.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[@href='download/dummy.txt']")).click();
        //dosyasinin basariyla indirilip indirilmedigini test edelim   "C:\Users\himer\Downloads\dummy.txt"
        String filePaths="D:\\Downloads\\dummy.txt";
        boolean ifFileExist= Files.exists(Paths.get(filePaths));
        System.out.println(Files.exists(Paths.get(filePaths)));
        Assert.assertTrue(Files.exists(Paths.get(filePaths)));
    }
}
//"D:\Downloads\dummy.txt"  "D:\Downloads\dummy.txt"   "D:\Downloads\dummy.txt" "C:\\Users\\himer\\Downloads\\dummy.txt"