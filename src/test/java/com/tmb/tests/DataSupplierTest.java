package com.tmb.tests;

import com.tmb.constants.FrameworkConstants;
import com.tmb.testData.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

public class DataSupplierTest {

    @Test(dataProvider = "getData")
    public void dataSupplierTest(TestData testData) {
        System.out.println(testData.getUsername());
    }

    @DataSupplier //Object[][] or Object[] //Test Data Supplier also has inbuilt ways to read test data from files like csv,json,xml,excel
    public StreamEx<TestData> getData(){
        return TestDataReader
                .use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource("testdata.xlsx")
                .read();
    }
}
