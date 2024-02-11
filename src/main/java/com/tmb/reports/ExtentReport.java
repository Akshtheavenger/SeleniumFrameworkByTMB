package com.tmb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tmb.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}

    public static ExtentReports extent;
    public static ExtentTest extentTest;

    public static void initReports(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportPath());
        extent.attachReporter(spark);
    }

    public static void flushReports(){
        if(Objects.nonNull(extent)){
            extent.flush();
        }
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getReportPath()).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTest(String testcaseName, String description){
        extentTest = extent.createTest(testcaseName,description);
        ExtentManager.setExtentTest(extentTest);
    }

    public static void assignAuthor(String author){
        ExtentManager.getExtentTest().assignAuthor(author);
    }
}
