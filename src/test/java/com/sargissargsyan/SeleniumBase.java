package com.sargissargsyan;

import com.google.gson.JsonObject;
import com.sargissargsyan.api.BaseService;
import com.sargissargsyan.base.DriverHelper;
import com.sargissargsyan.pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class SeleniumBase {

    public void login(JsonObject userJson) {
        new LoginPage().open();
        ((JavascriptExecutor) DriverHelper.get().getDriver())
                .executeScript("window.localStorage.setItem('token', " + userJson.get("auth_token") +");");
        ((JavascriptExecutor) DriverHelper.get().getDriver())
                .executeScript("window.localStorage.setItem('userInfo', '" + userJson +"');");
    }

    public void login(String username, String password) {
        JsonObject userJson = BaseService.login(username, password);
        login(userJson);
    }


    @AfterMethod
    public void cleanUpBase() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }
}
