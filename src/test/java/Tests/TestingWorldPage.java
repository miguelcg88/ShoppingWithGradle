package Tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class TestingWorldPage {
    private static final String PAGE_URL = "http://www.shop.theTestingWorld.com";
    ChromeDriver driver;
    WebDriverWait wait;

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

    @Test
    public void test01() {

        ResourceBundle rB = ResourceBundle.getBundle("ObjectRepository");


        String searchBar = rB.getString("searchBar_by_cssSelector");
        waitVisibility(By.cssSelector(searchBar));
        WebElement searchTxtField = driver.findElement(By.cssSelector(searchBar));
        searchTxtField.sendKeys("Iphone");

        String searchButton = rB.getString("searchButton_by_cssSelector");
        waitVisibility(By.cssSelector(searchButton));
        WebElement searchBtn = driver.findElement(By.cssSelector(searchButton));
        searchBtn.click();

        String addToCartButton = rB.getString("addToCart_by_xpath");
        waitVisibility(By.xpath(addToCartButton));
        WebElement addCartButton = driver.findElement(By.xpath(addToCartButton));
        addCartButton.click();

        String checkoutButton = rB.getString("checkoutButton_by_xpath");
        waitVisibility(By.xpath(checkoutButton));
        WebElement checkLink = driver.findElement(By.xpath(checkoutButton));
        checkLink.click();

        waitVisibility(By.cssSelector("input[value='guest']"));
        WebElement guestRadioBtn =  driver.findElement(By.cssSelector("input[value='guest']"));
        guestRadioBtn.click();

        waitVisibility(By.cssSelector("input[value='Continue']"));
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        waitVisibility(By.cssSelector("input[type='checkbox']"));
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        checkbox.click();

        String loc03 = "input[name='shipping_address']";
        waitVisibility(By.cssSelector(loc03));
        WebElement myDeliveryCheckBox = driver.findElement(By.cssSelector(loc03));
        if(myDeliveryCheckBox.isSelected())
        myDeliveryCheckBox.click();

        Select countryDrop = new Select(driver.findElementById("input-payment-country"));
        countryDrop.selectByValue("225");

    }

    private void waitVisibility(final By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


}
