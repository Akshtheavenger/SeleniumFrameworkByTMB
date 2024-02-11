package com.tmb.tests;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.driver.DriverManager;
import com.tmb.pages.LoginPage;
import com.tmb.reports.ExtentLogger;
import com.tmb.testData.TestData;
import com.tmb.utils.DataProviderUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest {


/*    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{
                {"Admin","admin123"}
        };
    }*/

    @FrameworkAnnotations(author = "Akshay")
    @Test(description = "Payment Test",dataProvider = "getData"
            ,dataProviderClass = DataProviderUtils.class)
    public void test2(TestData testData) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication(testData.getUsername(), testData.getPassword());
        Assert.assertEquals(DriverManager.getDriver().getTitle(),testData.getExpectedTitle());
        ExtentLogger.pass("Validated the title of the page as "+DriverManager.getDriver().getTitle());
    }
}
