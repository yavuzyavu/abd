package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void tes1() {

//“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
//“Our Products” butonuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@src=\"../Page-Object-Model/index.html\"]")));
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
//“Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[@id=\"camera-img\"]")).click();
//        Popup mesajini yazdirin
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"frame\"]")));
        WebElement popupElement = driver.findElement(By.xpath("//*[@class=\"modal-body\"]"));
        System.out.println(popupElement.getText());
//“close” butonuna basin
//        "WebdriverUniversity.com (IFrame)" linkini tiklayin
//        "http://webdriveruniversity.com/index.html" adresine gittigini test edin

    }
}
