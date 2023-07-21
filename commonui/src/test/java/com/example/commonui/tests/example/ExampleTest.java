package com.example.commonui.tests.example;

import com.example.commonui.androidConfiguration.AndroidBaseTest;
import com.example.commonui.lib.MainPageObject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ExampleTest extends AndroidBaseTest {

    @Test
    public void testSearchHelloWorld(){
        By helloWorldTextSelector = By.xpath("//*[contains(@text, 'Hello World!')]");

        MainPageObject mpo = new MainPageObject(driver);
        mpo.waitForElement(
                helloWorldTextSelector,
                "Hello world not found",
                (long) 10.0);
    }

}