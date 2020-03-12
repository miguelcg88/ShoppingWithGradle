package Tests;

import Base.DriverCreation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_Screenshot extends DriverCreation {



    @Test
    public void searchUsingKeys()
    {
        driver.findElementByName("search").sendKeys("Iphone");
        Actions act = new Actions(driver);
        act.sendKeys(Keys.RETURN).perform();
        File f1 = driver.getScreenshotAs(OutputType.FILE);
        File f2 = new File("D:\\IntelliJ Workspace\\ShoppingWithGradle\\out\\ResultTCScreenshot.png");
        try {
            FileUtils.copyFile(f1,f2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
