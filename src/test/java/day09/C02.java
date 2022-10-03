package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02 extends TestBase {


    @Test
    public void login() {
//
//        login( ) metodun oluşturun ve oturum açın.
//               https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
//        Username : manager
        driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys("manager");
//        ○ Password : Manager2!
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

//        Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println(sutunSayisi.size());
//        Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
       List<WebElement> bodyList = driver.findElements(By.xpath("//tbody"));
       for(WebElement w:bodyList){
           System.out.println(w.getText());
       }

//        printRows( ) metodu oluşturun //tr
//        table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println(driver.findElement(By.xpath("//tbody//tr")));
//       Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

//        4.satirdaki(row) elementleri konsolda yazdırın.
//                printCells( ) metodu oluşturun //td
//        table body’sinde bulunan toplam hücre(cell) sayısını bulun.
//                Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
//        printColumns( ) metodu oluşturun
//        table body’sinde bulunan toplam sutun(column) sayısını bulun.
//                Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
//        5.column daki elementleri konsolda yazdırın.

    }
}


