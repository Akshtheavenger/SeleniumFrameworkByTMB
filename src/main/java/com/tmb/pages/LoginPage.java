package com.tmb.pages;

import com.tmb.enums.WaitTypeStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentManager;
import org.openqa.selenium.By;

import static com.tmb.utils.SeleniumUtils.*;

public class LoginPage {
    private static final By TEXT_BOX_USERNAME = By.name("username");
    private static final By TEXT_BOX_PASSWORD = By.name("password");
    private static final By BTN_LOGIN = By.xpath("//button[@type='submit']");

    private LoginPage setUserName(String username){
        sendKeys(TEXT_BOX_USERNAME,username,"Username field");
        return this;
    }

    private LoginPage setPassword(String password){
        sendKeys(TEXT_BOX_PASSWORD,password,"Password field");
        return this;
    }

    private HomePage setLogIn(){
        click(BTN_LOGIN, "Login Button");
        return new HomePage();
    }

    public HomePage loginToApplication(String username, String password){ //This is Method Chaining.
        return setUserName(username).setPassword(password).setLogIn();
    }
}
