package com.tmb.driver;

import com.tmb.config.ConfigFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class RemoteDriverFactory {

    private RemoteDriverFactory(){}


    @SneakyThrows
    public static WebDriver getRemoteWebDriver(String browser)  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(browser.equalsIgnoreCase("Chrome")){
            capabilities.setBrowserName("Chrome");
        } else if (browser.equalsIgnoreCase("Firefox")) {
            capabilities.setBrowserName("Firefox");
        }
        return  new RemoteWebDriver(new URL(ConfigFactory.getConfig().remoteurl()),capabilities);
    }
}
