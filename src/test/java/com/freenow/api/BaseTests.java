package com.freenow.api;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTests {

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        Reporter.log("********************* API Automation Suite Started *********************", true);
    }

    @AfterMethod
    public void testComplete() {
        Reporter.log("********************* Test Complete *********************", true);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Reporter.log("********************* API Automation Suite Ended *********************", true);
    }
}
