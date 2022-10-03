package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C03 extends TestBase {
    @Test
    public void test1() {

        // amazon gidin
        driver.get("https://amazon.com");
//        Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdownMenuElement = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        Select select = new Select(dropdownMenuElement);
        // Test02
//        dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");

//        arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
       WebElement iphoneElement = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
       iphoneElement.sendKeys("ipohone"+ Keys.ENTER);
       WebElement sonucSayisi = driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        System.out.println("aaaaa = "+sonucSayisi.getText());

//        sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement iphoneElement1 = driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        Assert.assertTrue(iphoneElement1.getText().contains("iphone"));
//        ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class=\"s-image\"])[7]")).click();
//        ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

//
    }
}
