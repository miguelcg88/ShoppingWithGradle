package Tests;

import Verify.Compare;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_Assertions {

    private static final String PAGE_URL = "http://www.facebook.com";
    ChromeDriver driver;
    WebDriverWait wait;
    boolean result;

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
    public void tc01(){
        driver.findElementById("email").sendKeys("testEmail");
        result = Compare.validateURL(driver,"https://www.facebook.com/");
        Assert.assertTrue(result,"Error-not match");


    }

    @Test
    public void tc02()
    {
        Compare.validatePageTitle(driver,"Facebook - Log in or sign up");
        Assert.assertTrue(result,"Error-not match");
    }

    @Test
    public void verifyPasswordField()
    {
        //Compare.validateElement(driver, "//input[@id='pass']");
        Assert.assertTrue(Compare.validateElementByXpath(driver, "//input[@id='pass']"));
    }

    @Test
    public void verifyEmailField()
    {
        boolean result = Compare.validateElementExists(driver,"id","email");
        Assert.assertTrue(result,"tc failed");
    }

    @Test
    public void textOnFacebook()
    {
        boolean result = Compare.validateTextOnElement(driver,"id","privacy-link","Data Policy");
        Assert.assertTrue(result,"text not match");
    }

    @Test
    public void textOnElement()
    {
        String actResutl = Compare.validateTextOnElement2(driver,"id","privacy-link");
        Assert.assertEquals(actResutl,"Data Policy","error-dont match");
    }

    @Test
    public  void textOnPage()
    {
        boolean result = Compare.valdateTextOnPage(driver,"Email");
        Assert.assertTrue(result,"its not in the page");
    }
}
