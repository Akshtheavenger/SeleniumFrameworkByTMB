package com.tmb.utils;

import com.tmb.testData.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;

public class DataProviderUtils {

    @DataSupplier(runInParallel = false)
    //Object[][] or Object[] //Test Data Supplier also has inbuilt ways to read test data from files like csv,json,xml,excel
    public StreamEx<TestData> getData(Method method){
        return TestDataReader.use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource( "testdata.xlsx")
                .read()
                .filter(testData -> testData.getTestCase().equalsIgnoreCase(method.getName()));

    }
}
