package com.sargissargsyan.base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
@Log4j2
public class WaitHelper {
    public static WaitHelper getWait(){
        return new WaitHelper();
    }

    public void waitForElementToBeVisible(By location) {
        new WebDriverWait(DriverHelper.get().getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(location));
    }

    public void waitForElementToBeInVisible(By location) {
        new WebDriverWait(DriverHelper.get().getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOfElementLocated(location));
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
       return new WebDriverWait(DriverHelper.get().getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForLoading() {
        try {
            waitForElementToBeVisible(By.cssSelector(".loader"));
            waitForElementToBeInVisible(By.cssSelector(".loader"));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
        }

    }
}
