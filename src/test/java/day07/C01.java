package day07;

import org.bouncycastle.crypto.modes.KCCMBlockCipher;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void test01() {

//        Bir Class olusturalim KeyboardActions2
//        https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
//        3- video’yu gorecek kadar asagi inin
        //WebElement htmlElement = driver.findElement(By.xpath("(//*[@class=\"custom-logo sp-no-webp\"])[2]"));
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

//        videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@width=\"560\"]")));
        driver.findElement(By.xpath("//*[@class=\"ytp-large-play-button ytp-button ytp-large-play-button-red-bg\"]")).click();
//        videoyu calistirdiginizi test edin
        Boolean ccEtkinMi = driver.findElement(By.xpath("//*[@class=\"ytp-button ytp-settings-button\"]")).isEnabled();
        Assert.assertTrue(ccEtkinMi);
    }
}
