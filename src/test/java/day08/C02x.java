package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C02x extends TestBase {
    @Test
    public void test01() {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a  kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin


        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin
        String firstPageWH = driver.getWindowHandle();
        String secondPageWH = "";
        Set<String> windowHandlesSet = driver.getWindowHandles();

        for (String w : windowHandlesSet){
            if (!w.equals(firstPageWH))
                secondPageWH = w;
        }
        //5."username" ve  "password" kutularina deger yazdirin
        driver.switchTo().window(secondPageWH);
        actions.sendKeys(Keys.TAB).sendKeys("Sirin").
                sendKeys(Keys.TAB).sendKeys("123456").perform();

        //6."login" butonuna basin
        driver.findElement(By.tagName("button")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin  8.Ok diyerek Popup'i kapatin
        Assert.assertTrue(driver.switchTo().alert().getText().contains("validation failed"));
        //Ilk sayfaya geri donun
        driver.switchTo().alert().accept();
        //Ilk sayfaya donuldugunu test edin
        driver.switchTo().window(firstPageWH);

    }
}