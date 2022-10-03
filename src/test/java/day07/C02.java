package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02 extends TestBase {
    @Test
    public void test1() {

//        -  amazon gidin
        driver.get("https://amazon.com");
//        Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdownMenuElement = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        Select select = new Select(dropdownMenuElement);
        List<WebElement> dropDownList = select.getOptions();
        for(WebElement w : dropDownList){
            System.out.println(w.getText());
        }

//         dropdown menude 40 eleman olduğunu doğrulayın
        System.out.println(dropDownList.size());
        Assert.assertFalse(dropDownList.size()==40);


    }
}
