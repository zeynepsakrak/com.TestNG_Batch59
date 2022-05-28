package tests.day17_pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelPage;
import utilities.Driver;

public class C04_homework {
    @Test
    public void test02() {
        HotelPage hotelPage=new HotelPage();
        Driver.getDriver().get("https://www.hotelmycamp.com/");
        hotelPage.loginPageButton.click();
       hotelPage.nameKutusu.sendKeys("manager");
       hotelPage.sifreKutusu.sendKeys("Manager1!");
       hotelPage.LoginButton.click();
       String kullaniciadi="manager";
       Assert.assertEquals(hotelPage.isimKontrol.getText(),kullaniciadi);
        Driver.closeDriver();
    }
}
