package com.datacom.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class PageObject {
    public PageObject(WebDriver driver) {
        PageObject.driver = driver;
    }

    protected static WebDriver driver;
    protected static WebDriverWait wait;

//    public static void waitFor(By element, String condition) {
//        if (condition.equalsIgnoreCase("visible")) {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//        } else if (condition.equalsIgnoreCase("has attribute")) {
//            wait.until(ExpectedConditions.presenceOfElementLocated())
//        }
//
//    }

    public static void waitFor(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void goTo(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(15));
    }

    public static String getTitlePage() {
        return driver.getTitle();
    }

    public static void setValue(String value, By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(value);
    }

    public static void click(By element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            driver.findElement(element).click();
        } catch (Exception e) {
            scrollInto(element);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", driver.findElement(element));
        }

    }
    
    public static void scrollInto(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }

    public static String getText(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    public static String getAttribute(By element, String att) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getAttribute(att);
    }

}
