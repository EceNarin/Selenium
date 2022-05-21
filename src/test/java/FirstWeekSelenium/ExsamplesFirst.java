package FirstWeekSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ExsamplesFirst {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://zero.webappsecurity.com");
        //SignIn butonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"signin_button\"]")).click();
        //Login alanina "username" yazin
        WebElement login=driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        login.sendKeys("username");
        //paswword alanına pasword yazin
        WebElement passoword=driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        passoword.sendKeys("password");
        //signIn butonuna tiklayin
        WebElement signIn=driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input"));
        signIn.click();
        driver.navigate().back();
        //paybilss sayfasina gidin
        driver.findElement(By.xpath("//*[@id=\"onlineBankingMenu\"]/div/strong")).click();
        driver.findElement(By.xpath("//*[@id=\"pay_bills_link\"]")).click();
        //amount kismina miktar girin
        driver.findElement(By.xpath("//*[@id=\"sp_amount\"]")).sendKeys("1500");
        Thread.sleep(1500);
        //tarih kismina 2020/09/10
        driver.findElement(By.xpath("//*[@id=\"sp_date\"]")).sendKeys("2020-09-10");
        Thread.sleep(1500);
        //pay butonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"pay_saved_payees\"]")).click();
        Thread.sleep(1500);
        //"The payment was successfully submitted" yazisini kontrol et
        String extpectedword="The payment was successfully submitted.";
        WebElement actualWord= driver.findElement(By.xpath("//*[@id=\"alert_content\"]/span"));
        if(extpectedword.equals(actualWord.getText())){
            System.out.println("PASSED");
        }else{
            System.out.println( "FAILED");
        }
        Thread.sleep(4500);
     driver.close();
    }
}
