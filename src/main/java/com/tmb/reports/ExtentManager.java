package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentManager {

    private ExtentManager() {
    }

    private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

     static ExtentTest getExtentTest() {
        return threadLocal.get();
    }

        static void setExtentTest(ExtentTest extentTest) {
         if(Objects.nonNull(extentTest)){
             threadLocal.set(extentTest);
         }
    }

    static void unload() {
        threadLocal.remove();
    }
}
