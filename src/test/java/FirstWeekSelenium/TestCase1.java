package FirstWeekSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase1 {
    WebDriver driver;
    @Before
public void start(){
        //   1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
}
@After
public void close(){
    driver.close();
}
@Test
public void main(){

// 3. Verify that home page is visible successfully
   WebElement homePage= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
   if(homePage.isDisplayed()){
        System.out.println("HomePage is visible PASSED");
    }else{
        System.out.println("HomePage is visible FAILED");
    }
// 4. Click on 'Signup / Login' button
    driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
// 5. Verify 'New User Signup!' is visible
boolean isVisible= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).isDisplayed();
if(isVisible){
    System.out.println("New User is visible PASSED");
}else{
    System.out.println("New User is visible FAILED");
}
// 6. Enter name and email address
    driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Ece");
    driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("ecenarin70@hotmail.com");
// 7. Click 'Signup' button
    driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
// 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    boolean verify= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b")).isDisplayed();
    if(verify){
        System.out.println("Verify is visible PASSED");
    }else{
        System.out.println("Verify is visible FAILED");
    }
// 9. Fill details: Title, Name, Email, Password, Date of birth
    driver.findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Ece");
    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1234!");
    driver.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("23");
    driver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("01");
    driver.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("1990");
// 10. Select checkbox 'Sign up for our newsletter!'
    driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[6]/label")).click();
// 11. Select checkbox 'Receive special offers from our partners!'
    driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[7]/label")).click();
// 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Asya");
    driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Cinaroglu");
    driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("gkgkkkhkhkkk");
    driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("eebejejejd");
    driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("bernn");
    driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Bern");
    driver.findElement(By.xpath("//*[@id=\"country\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("7456");
    driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("46566673774747");


// 13. Click 'Create Account button'
    driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")).click();
// 14. Verify that 'ACCOUNT CREATED!' is visible
   String accountVisible=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
    if(accountVisible.equals("ACCOUNT CREATED!")){
        System.out.println("Creation is visible PASSED");
    }else{
        System.out.println("Creation is visible FAILED");
    }
// 15. Click 'Continue' button
    driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
// 16. Verify that 'Logged in as username' is visible
    boolean logVisible=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a")).isDisplayed();
    if(logVisible){
        System.out.println("Logged is visible PASSED");
    }else{
        System.out.println("Logged is visible FAILED");
    }
// 17. Click 'Delete Account' button
    driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"deleteModal\"]/div/div/div[2]/form/button")).click();


}
}
