package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {

    // Bir test method olustur positiveLoginTest()
    //       https://www.bluerentalcars.com/ adresine git
    //      login butonuna bas
    //test data user email: customer@bluerentalcars.com ,
    //test data password : 12345
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
    BrcPage brcPage=new BrcPage();
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
    brcPage.ilkLoginButton.click();
    brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
    brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
    brcPage.ikinciLoginButton.click();
    String actualUserName=brcPage.kullaniciProfilIsmi.getText();
    String expectedUserName=ConfigReader.getProperty("brcValidName");
        Assert.assertEquals(actualUserName,expectedUserName);
Driver.closeDriver();


    }
}
