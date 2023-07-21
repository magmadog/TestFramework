package com.example.commonui.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;

public class MainPageObject {

    private WebDriver driver;
    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator, String errorMessage, Long timeout) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        waiter.withMessage(errorMessage);
        return waiter.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
