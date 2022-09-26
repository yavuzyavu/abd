package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

import static org.openqa.selenium.By.*;

public class TestCase1_RegisterUser {

    //Test Case 1: Register User

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }

    //1. Launch browser
    @Test
    public void test01() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully
        WebElement webElement = driver.findElement(xpath("(//div[@class=\"product-overlay\"])[5]"));
        Assert.assertTrue("Verilen Site goruldu", webElement.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement signUp = driver.findElement(xpath("//*[@ href='/login']"));
        signUp.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUser.isDisplayed());

        //6. Enter name and email address
        //6. Adı ve e-posta adresini girin
        driver.findElement(xpath("//*[@name='name']")).sendKeys("abdullah");
        driver.findElement(xpath("(//input[@name='email'])[2]")).sendKeys("yytesksylta7a1pg2239454@gmail.com");

        //7. Click 'Signup' button
        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();


        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //9. Ayrıntıları doldur: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        Actions actions = new Actions(driver);
        WebElement titleElement = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        titleElement.click();
        Thread.sleep(2000);
        WebElement passwordElement = driver.findElement(By.xpath("//*[@id='password']"));
        passwordElement.sendKeys("123456");

        WebElement dayElement = driver.findElement(By.xpath("//*[@id='days']"));
        dayElement.sendKeys("29");

        WebElement monthElement = driver.findElement(By.xpath("//*[@id='months']"));
        monthElement.sendKeys("May");

        WebElement yearElement = driver.findElement(By.xpath("//*[@id='years']"));
        yearElement.sendKeys("2003");

        //10. Select checkbox 'Sign up for our newsletter!'
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();

        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();

    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    // 12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
       WebElement ad = driver.findElement(By.xpath("//*[@id='first_name']"));
       ad.sendKeys("abdullah");

        WebElement lastName = driver.findElement(By.xpath("//*[@id='last_name']"));
        lastName.sendKeys("Kadioglu");

        WebElement company = driver.findElement(By.xpath("//*[@id='company']"));
        company.sendKeys("Kadioglu");

        WebElement address = driver.findElement(By.xpath("//*[@id='address1']"));
        address.sendKeys("ortahisar");

        WebElement address2 = driver.findElement(By.xpath("//*[@id='address2']"));
        address2.sendKeys("trabzon");

        WebElement country = driver.findElement(By.xpath("//*[@id='last_name']"));
        country.sendKeys("TC");

        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        state.sendKeys("gurcesme");

        WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
        city.sendKeys("tokat");

        WebElement zipCode = driver.findElement(By.xpath("//*[@id='zipcode']"));
        zipCode.sendKeys("00000");

        WebElement mobilNumber = driver.findElement(By.xpath("//*[@id='mobile_number']"));
        mobilNumber.sendKeys("55555");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        //14. 'HESAP OLUŞTURULDU!' görünür
       WebElement element =  driver.findElement(By.xpath("//*[text()='Account Created!']"));
       Assert.assertTrue(element.isDisplayed());


    //15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
    //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='abdullah']")).isDisplayed());
    //17. Click 'Delete Account' button
        driver.findElement(By.xpath("(//*[@style='color:brown;'])[2]")).click();
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        //18.'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[text()='Delete Account'])[2]")).isDisplayed();

    //
}}