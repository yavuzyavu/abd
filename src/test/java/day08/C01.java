package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void test01() {

        //yeni bir sekme açarak amazon anasayfaya gidin
         driver.get("https://amazon.com");

         driver.switchTo().newWindow(WindowType.TAB).get("https://amazon.com");
         String ikncWndwHndle= driver.getWindowHandle();

    //        dropdown’dan bebek bölümüne secin
        WebElement dropdownMenuElement = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        Select select = new Select(dropdownMenuElement);
        select.selectByVisibleText("Baby");
//        bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement strollerElement = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        strollerElement.sendKeys("stroller"+ Keys.ENTER);
//        sonuç yazsının puset içerdiğini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        Assert.assertTrue(sonucYazisi.getText().contains("stroller"));
        System.out.println("aaaaa = "+sonucYazisi.getText());
//        5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class=\"s-image\"])[3]")).click();
//        6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
            WebElement titleElement = driver.findElement(By.xpath("//*[@id=\"productTitle\"]"));
            WebElement fiatElement = driver.findElement(By.xpath("(//span[@aria-hidden=\"true\"])[12]"));
            String urunTitle = titleElement.getText();
            String urunFiat = fiatElement.getText();
            driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
//        Test 4
//        1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
            WebElement StitleElement = driver.findElement(By.xpath("(//*[@class=\"a-truncate-cut\"])[1]"));
            String sepetTitle = StitleElement.getText();
           Assert.assertFalse(sepetTitle.contains(urunTitle));

            WebElement SfiatTitleElement = driver.findElement
                    (By.xpath("//*[@class=\"a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold\"]"));
            String sepetFiat = SfiatTitleElement.getText();
            Assert.assertTrue(sepetFiat.contains(urunFiat));

    }
}
