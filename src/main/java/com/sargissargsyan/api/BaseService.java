package com.sargissargsyan.api;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sargissargsyan.models.User;
import com.sargissargsyan.utils.ConfigReader;
import com.sargissargsyan.utils.MapBuilder;
import com.sargissargsyan.utils.Parser;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
@Log4j2
public class BaseService {
    private static final String BASE_URL = ConfigReader.getBaseUrl() + "/api/v1";
    private static final ThreadLocal<String> threadAuthToken = new ThreadLocal<>() {
    };

    @SneakyThrows
    public static JsonObject login(String username, String password) {
        JsonObject bodyJson = new JsonObject();
        bodyJson.addProperty("username", username);
        bodyJson.addProperty("password", password);
        bodyJson.addProperty("type", "normal");

        Response response;
        JsonObject responseJson = null;
        response = postAuth("/auth", bodyJson);
        String jsonString = response.body().string();
        responseJson = JsonParser.parseString(jsonString).getAsJsonObject();
        threadAuthToken.set(responseJson.get("auth_token").getAsString());
        return responseJson;
    }

    public static User register(User user) {
        Response response = postAuth("/auth/register", user);
        String jsonString = getJsonStringFromResponse(response);
        user = Parser.parse(jsonString, User.class);
        threadAuthToken.set(user.getAuthToken());
        dismissNewsletterRequest();
        return user;
    }

    public static void dismissNewsletterRequest() {
        MapBuilder<String, Object> bodyParams = new MapBuilder<>(true);
        bodyParams.put("key", "dont_ask_premise_newsletter");
        bodyParams.put("value", true);
        post("/user-storage", bodyParams.build());
    }

    @SneakyThrows
    public static Response post(String url, Object object) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(new Gson().toJson(object), mediaType);
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + threadAuthToken.get())
                .build();
        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new Error("HTTP error code " + response.code());
        }
        return response;
    }

    @SneakyThrows
    public static Response postAuth(String url, Object object) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(new Gson().toJson(object), mediaType);
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new Error("HTTP error code " + response.code());
        }
        return response;
    }

    @SneakyThrows
    public static Response patch(String url, Object object) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(new Gson().toJson(object), mediaType);
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .patch(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + threadAuthToken.get())
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new Error("HTTP error code " + response.code());
        }
        return response;
    }

    @SneakyThrows
    public static Response put(String url, Object object) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(new Gson().toJson(object), mediaType);
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .put(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + threadAuthToken.get())
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new Error("HTTP error code " + response.code());
        }
        return response;
    }

    @SneakyThrows
    public static void delete(String url, int objectId) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_URL + url + objectId)
                .delete()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + threadAuthToken.get())
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new Error("HTTP error code " + response.code());
        }
    }

    @SneakyThrows
    protected static String getJsonStringFromResponse(Response response) {
        return response.body().string();
    }
}
