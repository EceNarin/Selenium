package FirstWeekSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.applet.Main;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleGoogle {
  public static void main(String[] args) {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      //google'a gidip coockies'leri kabul edip kapatin
      driver.get("https://www.google.com/");
      //Sayfanin google ifadesi icerdigini test edin
      WebElement logo = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.LLD4me.yr19Zb.LS8OJ > div > img"));
      System.out.println( "bu" +logo.getText());
      String actualWord = logo.getText().trim();

      String expectedWord ="Google";
      if (actualWord.contains(expectedWord)) {
          System.out.println("Test PASSED");
      } else {
          System.out.println("FAILED");
      }
      //Arama cubuguna nutella yazip aratin
      driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Nutella");
      driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
      ///html/body/div[7]/div/div[7]/div[1]/div/div/div/div
      System.out.println(driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText());
      System.out.println("Result of" + driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText());
      //sınuc sayısının 10 milyondan fazla oldugunu test edin
      String a = driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText();

      String[] arr = driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText().replaceAll("[^0-9]", "").split(",");
      System.out.println("Result of " + driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText());
      String[] results = driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText().split(" ");
      System.out.println(Arrays.toString(results));
      System.out.println(results[1].replaceAll("[^0-9]", ""));
      Integer resultInt = Integer.parseInt(results[1].replaceAll("[^0-9]", ""));
      if(resultInt>10000000){
          System.out.println("Result bigger than 10 million : PASSED");
      }else{
          System.out.println("Result bigger than 10 million : FAILED");
      }
      driver.close();
  }
    }

