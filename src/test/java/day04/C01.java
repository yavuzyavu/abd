package day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void test1() {
        // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // 3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
//    Sayfayi “refresh” yapin
        driver.navigate().refresh();
//    Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedTitle = "Spend less";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
//    Gift Cards sekmesine basin
        driver.findElement(By.xpath("(//*[@tabindex='0'])[11]")).click();
//    Birthday butonuna basin
       driver.findElement(By.xpath("//*[@alt='Birthday gift cards']")).click();
//    Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@alt=\"Amazon.com eGift Card\"])[1]")).click();
//    9- Gift card details’den 50 $’i secin
        driver.findElement(By.xpath("(//*[@class=\"a-button-text\"])[26]")).click();
//    10-Urun ucretinin 50$ oldugunu test edin
        String expectedPrice = "$50.00";
        String actualPrice = driver.findElement(By.xpath("(//*[text()='$50.00'])[2]")).getText();
        System.out.println(actualPrice);
        Assert.assertTrue(actualPrice.contains(expectedPrice));
//    10-Sayfayi kapatin
        driver.close();

    }
}

