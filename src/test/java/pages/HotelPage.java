package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelPage {
    public HotelPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    public WebElement loginPageButton;
    @FindBy(name="UserName")
    public WebElement nameKutusu;
    @FindBy(id = "Password")
    public WebElement sifreKutusu;
    @FindBy(id = "btnSubmit")
    public WebElement LoginButton;
    @FindBy(xpath = "//span[contains(text(),'manager')]")
    public WebElement isimKontrol;
}
