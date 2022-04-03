package com.it_academy.onliner_api.utils;

import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;

import java.util.List;

public class ResponseBodyUtils {

    private ResponseBodyUtils() {
    }

    @Step("Getting objects by Json Path")
    public static <T> List<T> getObjectsByJsonPath(ResponseBody responseBody, String jsonPath,
                                                   Class<T> genericType) {
        return responseBody
                .jsonPath()
                .getList(jsonPath, genericType);
    }
}