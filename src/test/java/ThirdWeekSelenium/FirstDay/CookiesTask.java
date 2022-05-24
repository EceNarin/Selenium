package ThirdWeekSelenium.FirstDay;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class CookiesTask extends TestBase {
    @Test
    public void Test(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        driver.manage().getCookies().stream().forEach(t-> System.out.println(t +" - "));
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Set<Cookie> allCookiess=driver.manage().getCookies();
        Assert.assertTrue(allCookiess.size()>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals("USD"));
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        driver.manage().addCookie(new Cookie("en sevdigim cookie","cikolatali"));
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(driver.manage().getCookieNamed("en sevdigim cookie").getValue().equals("cikolatali"));
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertTrue(!allCookiess.contains(driver.manage().getCookieNamed("skin")));
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        Assert.assertTrue(driver.manage().getCookies().size()==0);
    }
}
