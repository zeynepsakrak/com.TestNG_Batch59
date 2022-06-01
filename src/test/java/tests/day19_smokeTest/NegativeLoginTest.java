package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {

    // Bir test method olustur positiveLoginTest()
    //       https://www.bluerentalcars.com/ adresine git
    //      login butonuna bas
    //test data user email: customer@bluerentalcars.com ,
    //test data password : 54321
    //Degerleri girildiginde sayfaya basarili sekilde girilemediğini test et
    BrcPage brcPage=new BrcPage();
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        brcPage.ilkLoginButton.click();
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        brcPage.ikinciLoginButton.click();
        Assert.assertTrue(brcPage.ikinciLoginButton.isDisplayed());


        Driver.closeDriver();
    }
    //bu class da iki method daha oluştur
    //1. yanlış kullanıcı
    //2. yanlış şifre ve kullanıcı adı

}
