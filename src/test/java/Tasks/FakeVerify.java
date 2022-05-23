package Tasks;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class FakeVerify extends TestBase {
    @Test
    public void test() throws InterruptedException {
       // https://automationexercise.com/
       // use mouse action ve fakeframe
        driver.get("https://automationexercise.com/");
        //click to sign in button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //click enter username email
        Actions action=new Actions(driver);
        Faker fake=new Faker();
        //String fakeMail=action.click(driver.findElement(By.xpath("(//input[@type='email'])[1]"))).sendKeys(fake.internet().emailAddress()).;
        //System.out.println(fakeMail);
        action.click(driver.findElement(By.xpath("//input[@type='text']"))).sendKeys(fake.name().name()).sendKeys(Keys.TAB)
                .sendKeys(fake.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //action.click(driver.findElement(By.xpath("(//input[@type='email'])[1]"))).sendKeys(fake.internet().emailAddress()).sendKeys(Keys.TAB).click().perform();
        //driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
        //fill in the forms
        action.click(driver.findElement(By.xpath("(//input[@type='radio'])[1]"))).sendKeys(Keys.END).sendKeys(Keys.TAB)
                .sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(fake.internet().password()).sendKeys(Keys.TAB).sendKeys("23").sendKeys(Keys.TAB)
                .sendKeys("January").sendKeys(Keys.TAB).sendKeys("1990").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(fake.name().lastName()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(fake.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("United States").sendKeys(Keys.TAB).sendKeys(fake.address().state()).sendKeys(Keys.TAB).sendKeys(fake.address().city())
                .sendKeys(Keys.TAB).sendKeys(fake.address().zipCode()).sendKeys(Keys.TAB).sendKeys(fake.phoneNumber().cellPhone()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
        //test it if account created text if visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).isDisplayed());

    }
}
