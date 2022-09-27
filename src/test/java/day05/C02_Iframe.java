package day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_Iframe extends TestBase {

    @Test
    public void test1() {
//        Bir class olusturun: IframeTest02
//        http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
//        sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList = driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe sayisi : "+iframeList.size());

//        ilk iframe'deki (Youtube) play butonuna tıklayınız.
       // WebElement iframeElement = driver.findElement(By.xpath("//*[@width=\"560\"]"));
        //driver.switchTo().frame(iframeElement);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe"))).get("");
        WebElement youtube = driver.findElement(By.xpath("//*[@class=\"ytp-large-play-button ytp-button ytp-large-play-button-red-bg\"]"));
        youtube.click();

//        ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
//        ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
//        tıklayınız
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe"))).get("https://www.guru99.com/live-selenium-project.html");
    }
}
