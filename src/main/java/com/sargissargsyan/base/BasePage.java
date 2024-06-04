package com.sargissargsyan.base;

import com.sargissargsyan.utils.ConfigReader;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public abstract class  BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    protected static final String BASE_URL = ConfigReader.getBaseUrl();

    public BasePage() {
    }

    @Override
    protected void load() {
        DriverHelper.get().getDriver().get(BASE_URL + getUrl());
    }

    protected T openPage() {
        PageFactory.initElements(DriverHelper.get().getDriver(), this);
        load();
        return get();
    }

    public abstract T open();

    public abstract T init();

    protected T initPage() {
        PageFactory.initElements(DriverHelper.get().getDriver(), this);
        return get();
    }

    public <T extends BasePage> T initElements() {
        PageFactory.initElements(DriverHelper.get().getDriver(), this);
        return (T) this;
    }


    public abstract String getUrl();



}
