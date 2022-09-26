package day03;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_XPath_AddRemove extends TestBase {
    @Test
    public void test1() {
        //1
//    https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//   2 Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
//    3Delete butonu’nun gorunur oldugunu test edin
        driver.findElement(By.xpath("//*[text()='Delete']")).isDisplayed();
//   4 Delete tusuna basin
        driver.findElement(By.xpath("//*[text()='Delete']")).click();

//   5 Add/Remove Elements ” yazisinin gorunur oldugunu test edin
        driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")).isDisplayed();



    }

}
