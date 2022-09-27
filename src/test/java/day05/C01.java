package day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void test1() {
//        Bir Class olusturalim YanlisEmailTesti
//        http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
//        Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class=\"login\"]")).click();
//        Email kutusuna @isareti olmayan bir mail yazip enter’a
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        email.sendKeys("abdullah.gmail.com", Keys.ENTER);
//        bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//li)[15]")).isDisplayed());

    }
}
