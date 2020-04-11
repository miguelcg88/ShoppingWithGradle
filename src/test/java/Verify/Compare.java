package Verify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compare {

    public static boolean validateURL(WebDriver driver, String expURL)
    {
        boolean result = false;
        if (driver.getCurrentUrl().equalsIgnoreCase(expURL))
        {
            result = true ;
        }
        return result;
    }

    public static boolean validatePageTitle(WebDriver driver, String expTitle)
    {
        boolean result = false;
        if (driver.getTitle().equalsIgnoreCase(expTitle))
        {
            result = true ;
        }
        return result;
    }
    /* validate  by xpath */
    public static boolean validateElementByXpath(WebDriver driver, String xpath)
    {
        boolean result = false;

        try {
            driver.findElement(By.xpath(xpath));
            result = true;
        }catch (Exception e)
        {
            System.out.println("element not exists");
        }
        return result;

    }
    /* validate  if web element exist   */
    public static boolean validateElementExists(WebDriver driver, String locType, String locValue)
    {
        boolean result = false;

        try {
            if(locType.equalsIgnoreCase("xpath"))
            {
                driver.findElement(By.xpath(locValue));
            }
            else if(locType.equalsIgnoreCase("id"))
            {
                driver.findElement(By.id(locValue));
            }
            else if(locType.equalsIgnoreCase("name"))
            {
                driver.findElement(By.name(locValue));
            }

            result = true;


        }catch (Exception e)
        {
            System.out.println("element not exists");
        }

        return result;

    }
    /* validate text in q web element  */
    public static boolean validateTextOnElement(WebDriver driver, String locType, String locValue, String expText)
    {
        boolean result = false;
        String actValue = "";

        try {
            if(locType.equalsIgnoreCase("xpath"))
            {
               actValue =  driver.findElement(By.xpath(locValue)).getText();
            }
            else if(locType.equalsIgnoreCase("id"))
            {
                actValue =  driver.findElement(By.id(locValue)).getText();
            }
            else if(locType.equalsIgnoreCase("name"))
            {
                actValue =  driver.findElement(By.name(locValue)).getText();
            }

            if (actValue.equals(expText))
            {
                result = true;
            }
        }
        catch (Exception e)
        {}

        return result;
    }



    /* validate text in q web element  , case 2 */
    public static String  validateTextOnElement2(WebDriver driver, String locType, String locValue)
    {
        String actValue = "";

        try {
            if(locType.equalsIgnoreCase("xpath"))
            {
                actValue =  driver.findElement(By.xpath(locValue)).getText();
            }
            else if(locType.equalsIgnoreCase("id"))
            {
                actValue =  driver.findElement(By.id(locValue)).getText();
            }
            else if(locType.equalsIgnoreCase("name"))
            {
                actValue =  driver.findElement(By.name(locValue)).getText();
            }

        }
        catch (Exception e)
        {}

        return actValue;
    }

    /* validate text on page */

    public static boolean valdateTextOnPage(WebDriver driver,String expValue)
    {
        boolean result = false;
        if(driver.getPageSource().contains(expValue))
        {
            result = true;
        }
        return result;
    }
}
