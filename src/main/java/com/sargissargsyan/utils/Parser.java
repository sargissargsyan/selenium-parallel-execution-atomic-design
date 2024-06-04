package com.sargissargsyan.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
@Log4j2
public class Parser {

    private Parser() {
    }

    @SneakyThrows
    public static <T> T parse(JsonObject jsonObject, Class<T> tClass) {
        T value = null;
        Gson gson = new Gson();
        try {
            value = gson.fromJson(jsonObject, tClass);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return value;
    }
    @SneakyThrows
    public static <T> T parse(String json, Class<T> tClass) {
        T value = null;
        Gson gson = new Gson();
        try {
            value = gson.fromJson(json, tClass);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return value;
    }


}