package com.sargissargsyan.utils;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {


    @Getter
    private static String baseUrl;
    @Getter
    private static String browser;
    @Getter
    private static boolean remote;
    @Getter
    private static String gridUrl;

    static {
        InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();

        try {
            // Load properties file
            prop.load(input);

            baseUrl = prop.getProperty("base.url");
            browser = prop.getProperty("selenium.browser");
            remote = Boolean.parseBoolean(prop.getProperty("selenium.remote"));
            gridUrl = prop.getProperty("selenium.grid.url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}