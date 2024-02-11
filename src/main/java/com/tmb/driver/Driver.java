package com.tmb.driver;

import com.tmb.config.ConfigFactory;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentManager;
import com.tmb.reports.ExtentReport;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

public final class Driver {

    private Driver(){}

    //Common for all threads
    public static void initDriver() {
        String browser = ConfigFactory.getConfig().browser();
        String runMode = ConfigFactory.getConfig().runmode();
        if(Objects.isNull(DriverManager.getDriver())) {
            WebDriver driver = DriverFactory.getDriver(browser,runMode);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        }
    }
    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
            DriverManager.setDriver(null); //Delete if facing issues
        }

    }
}
