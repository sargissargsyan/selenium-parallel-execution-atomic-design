package com.sargissargsyan.utils;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class TestUtils {
    private static final String AB = "abcdefghijklmnopqrstuvwxyz1234567890";
    private static final SecureRandom RND = new SecureRandom();

    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(RND.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomNumber(int len) {
        return String.valueOf(len < 1 ? 0 : new Random()
                .nextInt((9 * (int) Math.pow(10, len - 1.0)) - 1)
                + (int) Math.pow(10, len - 1.0));
    }

    public static String randomEmail(String username) {
        return username + "@user.test";
    }

    private static Map<String, Object> createMap(Object... params) {
        assert params.length % 2 == 0 : "params must have an even number of elements";
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < params.length; i += 2) {
            map.put(params[i].toString(), params[i + 1]);
        }
        return map;
    }
}
