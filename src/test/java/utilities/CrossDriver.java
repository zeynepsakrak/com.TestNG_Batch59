package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;
public class CrossDriver {
    private  CrossDriver(){
    }
    static WebDriver driver;
    public static WebDriver getDriver(String browser){
        browser = (browser == null) ? ConfigReader.getProperty("browser") : browser;

        if (driver==null) {
            switch (ConfigReader.getProperty("browser")){
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case"edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    // headless-chrome Crome açılmadan testleri yapıyormuş
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                default:
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){ // driver'a deger atanmissa
            driver.close();
            driver=null;
        }
    }
}