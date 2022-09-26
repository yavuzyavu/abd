package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_junit {
    WebDriver driver;
    //a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes
    //b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //c. Checkbox1 seçili değilse onay kutusunu tıklayın
    //d. Checkbox2 seçili değilse onay kutusunu tıklayın


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        // driver.close();
    }

    //a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");


        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()) {
            checkBox1.click();

        }
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()) {
            checkBox2.click();

        }
    }
}







