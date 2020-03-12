package Tests;

import Base.DriverCreation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC004_MouseOperations extends DriverCreation {

    @Test
    public void mouseOver()
    {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElementByXPath("//a[text()='Laptops & Notebooks']")).perform();
        driver.findElementByXPath("//a[text()='Show All Laptops & Notebooks']").click();
    }
}
