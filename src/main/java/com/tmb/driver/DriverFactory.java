package com.tmb.driver;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory(){}

    @SneakyThrows
    public static WebDriver getDriver(String browserName, String runmode) {
        WebDriver driver = null;
        if(runmode.equalsIgnoreCase("Local")){
           driver =  LocalDriverFactory.getLocalDriver(browserName);
        } else if (runmode.equalsIgnoreCase("Remote")){
                driver =  RemoteDriverFactory.getRemoteWebDriver(browserName);
        }

        return driver;
    }
}
