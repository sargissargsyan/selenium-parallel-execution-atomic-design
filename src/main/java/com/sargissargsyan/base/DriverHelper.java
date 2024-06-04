package com.sargissargsyan.base;

import com.sargissargsyan.utils.ConfigReader;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class DriverHelper {
    public static String BROWSER = ConfigReader.getBrowser();
    public static boolean REMOTE = ConfigReader.isRemote();
    public static String GRID_URL = ConfigReader.getGridUrl();

    public static DriverHelper get() {
        return new DriverHelper();
    }

    public static WebDriver driver;
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    @SneakyThrows
    public WebDriver getDriver() {
        if (driverThread.get() == null) {
            WebDriver driver = null;
            switch (BROWSER) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (REMOTE) {
                        driver = initRemoteDriver(chromeOptions);
                    } else {
                        driver = new ChromeDriver(chromeOptions);
                    }
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (REMOTE) {
                        driver = initRemoteDriver(firefoxOptions);
                    } else {
                        driver = new FirefoxDriver(firefoxOptions);
                    }
                    break;
            }
            driverThread.set(driver);
        }
        return driverThread.get();
    }

    @SneakyThrows
    public static WebDriver initRemoteDriver(AbstractDriverOptions options) {
        return new RemoteWebDriver(new URL(GRID_URL), options);

    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
        driverThread.remove();
    }
}
