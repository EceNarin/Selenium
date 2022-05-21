package FirstWeekSelenium;

import FirstWeekSelenium.TestCase1;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestCase2 {
    static TestCase1 test=new TestCase1();
    @BeforeClass
    public static void start(){
        //1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
        test.start();
    }
    @AfterClass
    public static void close(){
        test.close();
    }
    @Test
    public void Test(){
       // 3. Verify that home page is visible successfully
        boolean ifTrue=test.driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img")).isDisplayed();
       Assert.assertTrue("Succesfully",ifTrue);
       //4. Click on 'Signup / Login' button
       test.driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
       // 5. Verify 'Login to your account' is visible
        Assert.assertTrue("Succesfull",test.driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).isDisplayed());
        //6. Enter correct email address and password
        test.driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("ecenarin1@hotmail.com");
        test.driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("1234!");
        //7. Click 'login' button
        test.driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(test.driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a/b")).isDisplayed());
        //9. Click 'Delete Account' button
        test.driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible

        Assert.assertEquals("Succesfull!","Delete",test.driver.findElement(By.xpath("//*[@id=\"deleteModal\"]/div/div/div[2]/form")).getText());
    }
}
