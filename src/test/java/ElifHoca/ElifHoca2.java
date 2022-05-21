package ElifHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElifHoca2 {
    WebDriver driver;
    @Before
    public void start(){
        //  1-driver olusturalim
        WebDriverManager.chromedriver().setup();
        //  2-java class'imiza chromedriver.exe'yi tanitalim
        driver=new ChromeDriver();
        //  3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();
        //  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void close(){
        //  13-En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.close();
    }
    @Test
    public void test2(){
        //  5-"sahibinden.com" adresine gidelim
        driver.get("https://sahibinden.com");
        //  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String title= driver.getTitle();
       //String title= driver.findElement(By.xpath("/html/body/div[3]/div/p/a")).getText();
        String currentUrl= driver.getCurrentUrl();
        //  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        if(title.contains("Oto")){
            System.out.println("TITLE Contains oto words: PASSED ");
        }else{
            System.out.println("TITLE HAS Not Contains oto words: FAILED");
        }
        if(currentUrl.contains("Oto")){
            System.out.println("URL Contains oto words: PASSED ");
        }else{
            System.out.println("URL HAS Not Contains oto words: FAILED");
        }
        //  8-Ardindan "gittigidiyor.com" adresine gidelim
        driver.get("https://gittigidiyor.com");
        //  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String ggTitle=driver.getTitle();
        if(ggTitle.contains("Sitesi")){
            System.out.println("GittiGidiyor title has expected word: PASSED");
        }else{
            System.out.println("GittiGidiyor title has NOT expected word: FAILED");
        }
        //  10-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        //  11-sayfayi yenileyelim
        driver.navigate().refresh();
        //  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();
      }
}
