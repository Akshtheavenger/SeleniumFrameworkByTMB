package com.tmb.tests;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.listeners.TestListener;
import com.tmb.pages.LoginPage;
import com.tmb.reports.ExtentLogger;
import com.tmb.testData.TestData;
import com.tmb.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = TestListener.class)
public class HomePageTest extends BaseTest {

    @FrameworkAnnotations(author = "Akshay")
    @Test(description = "To check whether the title of the Orange HRM homepage is displayed correctly",dataProvider = "getData"
    ,dataProviderClass = DataProviderUtils.class)
    public void titleValidationTest(TestData testData) {
     //   LoginPage loginPage = ;
        String actualHomePageTitle = new LoginPage().loginToApplication(testData.getUsername(), testData.getPassword()).getHomePageTitle();
        Assert.assertEquals(actualHomePageTitle,testData.getExpectedTitle());
        ExtentLogger.pass("Validated the title of the page as "+actualHomePageTitle);
    }
    //Important points to keep in mind while developing framework
    //1. Keep the right things at the right place
    //2. No Hardcoding
    //3. Keep Things as simple as possible
}
