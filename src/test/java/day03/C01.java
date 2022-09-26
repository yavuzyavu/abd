package day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void test1() {

//        1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//        2- Add Element butonuna 10 kez basinız

            WebElement element = driver.findElement(By.xpath("//*[text()='Add Element']"));

        for (int i = 0; i <10 ; i++) {
            element.click();
        }

//         3- 10 kez Add element butonuna basıldığını test ediniz
        driver.findElement(By.xpath("(//*[text()='Delete'])[10]")).isDisplayed();

//        4 - Delete butonuna görünmeyene kadar basınız
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.xpath("(//button[@class='added-manually'])[1]")).click();
        }
//        5- Delete butonunun görünmediğini test ediniz
        WebElement anaSayfa = driver.findElement(By.className("no-js"));
        System.out.println("anasayfa : "+anaSayfa.getText());
        String deleteButton = "Delete";
        if (!anaSayfa.getText().contains(deleteButton)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");
        //6- Sayfayı kapatınız
        //driver.close();
    }
}
