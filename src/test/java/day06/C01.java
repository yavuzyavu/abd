package day06;

import com.beust.ah.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01 extends TestBase {

    @Test
    public void test() {

//        Yeni Class olusturun ActionsClassHomeWork
//        1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
//        2- Hover over Me First" kutusunun ustune gelin
        WebElement firstElement = driver.findElement(By.xpath("(//*[@class=\"dropbtn\"])[2]"));
        Actions actions = new Actions(driver) ;
        actions.moveToElement(firstElement).perform();

//        Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class=\"list-alert\"])[2]")).click();
//        Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
//        Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
//“Click and hold" kutusuna basili tutun
        WebElement clickHoldElement = driver.findElement(By.xpath("//*[@id=\"click-box\"]"));
       actions.moveToElement(clickHoldElement).clickAndHold().perform();
    //        7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHoldElement.getText());
//        8- “Double click me" butonunu cift tiklayin
        WebElement doubleElement = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(doubleElement).perform();
    }
}
