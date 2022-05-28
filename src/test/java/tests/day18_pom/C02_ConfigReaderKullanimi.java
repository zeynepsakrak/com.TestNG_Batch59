package tests.day18_pom;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test01() {
        FacebookPage facebookPage=new FacebookPage();
        // facebook anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // cikarsa cookies kabul edin
        //facebookPage.cookieButonu.click();

        // kullanici mail kutusuna rastgele bir isim yazdirin
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));

        // kullanici sifre kutusuna rastgele bir password yazdirin
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        // login butonuna basin
        facebookPage.loginTusu.click();

        //giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

        //driverı kapatın
        Driver.closeDriver();

    }
}
