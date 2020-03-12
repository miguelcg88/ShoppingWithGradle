package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class DriverCreation {
    public static final String PAGE_URL = "http://www.shop.theTestingWorld.com";
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

    //    @AfterMethod
//    public void afterMethod() {
//        driver.quit();
//        System.out.println("after");
//    }
}
