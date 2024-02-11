package com.tmb.utils;

import com.tmb.config.ConfigFactory;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitTypeStrategy;
import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class SeleniumUtils {

    private SeleniumUtils(){}

    public static void click(By by, String elementName){
        WebElement webElement = waitUntilElementPresent(by);
        webElement.click();
        ExtentLogger.pass(elementName + " is clicked successfully");
    }

    public static void click(By by, WaitTypeStrategy waitTypeStrategy, String elementName){
        WebElement webElement = null;
        if(waitTypeStrategy == WaitTypeStrategy.CLICKABLE){
            webElement = waitUntilElementClickable(by);
        }
        else if(waitTypeStrategy == WaitTypeStrategy.PRESENCE){
            webElement = waitUntilElementPresent(by);
        } else if (waitTypeStrategy == WaitTypeStrategy.VISIBLE) {
            webElement = waitUntilElementIsVisible(by);
        }
        webElement.click();
        ExtentLogger.pass(elementName + " is clicked successfully");
    }

    public static void sendKeys(By by, String value, String elementName){
        WebElement webElement = waitUntilElementPresent(by);
        webElement.sendKeys(value);
        ExtentLogger.pass(value + " is entered "+ " successfully in the " +elementName);
    }

    public static String getText(By by){
        WebElement webElement = waitUntilElementPresent(by);
        return webElement.getText();
    }

    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private static WebElement waitUntilElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    private static WebElement waitUntilElementIsVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
