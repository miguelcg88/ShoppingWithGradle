package Tests;

import Base.DriverCreation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_003_LoginFacebook_sendKeys  extends DriverCreation {

        private static final String PAGE_URL = "http://www.facebook.com";
        public ChromeDriver driver;
        public WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().clearPreferences();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.get(PAGE_URL);
        System.out.println("before");
    }


    @Test
        public void searchUsingKeys()
        {
            driver.findElementById("email").sendKeys("testEmail");
            Actions act = new Actions(driver);
            act.sendKeys(Keys.TAB).perform();
            act.sendKeys("pass").perform();
            act.sendKeys(Keys.RETURN).perform();
        }
}
